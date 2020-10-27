package models;

import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animal {
    private int id;
    private String animalName;

    public Animal(int id, String animalName) {
        this.id = id;
        this.animalName = animalName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void addAnimalSightedByRanger(){

    }

    public void getAnimalLocations(){

    }

    public List<Animal> getAllAnimals(){
        String sql = "SELECT * FROM animal";
        try(Connection con = DB.sql2o.open()){
         return con.createQuery(sql)
                 .executeAndFetch(Animal.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
           return null;
        }
    }

}
