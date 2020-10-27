package models;

import DB.DB;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Animal {
    private int id;
    private String animalName;
    private int rangerId;
    private int locationId;

    public Animal(String animalName, int rangerId, int locationId) {
        this.animalName = animalName;
        this.rangerId = rangerId;
        this.locationId = locationId;
    }

    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
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



}
