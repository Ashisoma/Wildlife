package models;

public class Sightings extends Rangers{
    private String location;
    //private String rangerName;
    private int animalId;
    private int dangerId;

    public Sightings(String location) {
        this.location = location;


    }

    public String getLocation() {
        return location;
    }


    public int getAnimalId() {
        return animalId;
    }

    public int getDangerId() {
        return dangerId;
    }

    public void getSightingById(int id){

    }

    public void getLatestSighting(){

    }

    public void getSightingByRanger(int id){

    }

    public void getAllSightings(){

    }
}
