package models;

import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animal extends Wildlife {
    public static final String DATABASE_TYPE = "animal";

    public Animal(String animalName) {
        this.name = animalName;
        this.type = DATABASE_TYPE;

    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public static List<Animal> getAllAnimals() {
        String sql = "SELECT * FROM animals WHERE type='animal'  ";
        try(Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animal.class);
        }catch (Sql2oException ex){
            System.out.println(ex);
            return null;
        }

    }

    public void setId(int id) {
    }
}
