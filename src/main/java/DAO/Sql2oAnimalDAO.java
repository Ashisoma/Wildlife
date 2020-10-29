package DAO;

import models.Animal;
import models.Wildlife;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimalDAO implements AnimalDAO{

    private final Sql2o sql2o;

    public Sql2oAnimalDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void addAnimalName(String name) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO animals(animalName, type) VALUES(:animalName, 'animal')";
            Wildlife.id = (int) con.createQuery(sql, true)
                    .addParameter("animalName", name)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();

        }
    }
    @Override
    public List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals WHERE type='animal' ";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

}
