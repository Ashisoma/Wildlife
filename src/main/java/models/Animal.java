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




}
