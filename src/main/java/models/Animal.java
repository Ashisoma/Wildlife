package models;

import DB.DB;
import org.sql2o.Connection;

import java.util.List;

public class Animal {
    private int id;
    private String animalName;

    public Animal(int id, String animalName) {
        this.id = id;
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

    public static List<Animal> getAllAnimals(){
        String sql = "SELECT * FROM animal";
        try(Connection con = DB.sql2o.open()){
         return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }
}
