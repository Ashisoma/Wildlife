package DAO;

import models.Animal;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oAnimalDAO implements AnimalDAO{

    private final Sql2o sql2o;

    public Sql2oAnimalDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals";
        try(Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }

    @Override
    public void addAnimal(Animal animal) {
      String sql = "INSERT INTO animals (animalName, rangerId, locationId) VALUES (:animalName, :rangerId, :locationId)";
      try (Connection con = sql2o.open()){
          int id = (int) con.createQuery(sql, true)
                  .bind(animal)
                  .executeUpdate()
          .getKey();
          animal.setId(id);
      }
    }

    @Override
    public Animal getAnimalById(int id) {
        String sql = "SELECT * FROM animals WHERE id=:id";
        try (Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animal.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }
    }
}