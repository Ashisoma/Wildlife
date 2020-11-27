package DAO;

import models.Animal;
import models.Endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class EndangeredDAO implements Sql2oEndangered {
    public  final String DATABASE_TYPE = "animal";

    private final Sql2o sql2o;

    public EndangeredDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Endangered> getAllEndangeredAnimals() {
        String sql = "SELECT * FROM animals WHERE type='endangered'  ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Endangered.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void addEndangeredAnimal(Endangered endangered) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO animals(animalName, health, type) VALUES(:animalName,:health ,:type)";
            int id = (int) con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .bind(endangered)
                    .executeUpdate()
                    .getKey();
        endangered.setId(id);
        }
    }

}

