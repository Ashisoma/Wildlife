package DAO;

import models.Animal;
import models.Endangered;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class EndangeredDAO implements Sql2oEndangered{
    private final Sql2o sql2o;

    public EndangeredDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }
    @Override
    public List<Endangered> getAllEndangeredAnimals() {
        String sql = "SELECT * FROM endangeredAnimals";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Endangered.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void addEndangeredAnimal(Endangered endangered) {
        String sql = "INSERT INTO endangeredAnimals (dangerName, health, age, rangerId, locationId) VALUES (:dangerName, :health, :age, :rangerId, :locationId)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql, true)
                    .bind(endangered)
                    .executeUpdate()
                    .getKey();
            endangered.setId(id);
        }

    }

    @Override
    public Endangered getEndangeredAnimalById(int id) {
       String sql = "SELECT * FROM endangeredAnimals WHERE id=:id";
        try (Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Endangered.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }
}
