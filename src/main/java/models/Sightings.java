package models;

import java.sql.Timestamp;

public class Sightings {
    private String location;
    private String rangerName;
    private int wildlifeId;
    private int id;

    private Timestamp time;

    public Sightings(String location, String rangerName, int wildlifeId){
        this.rangerName = rangerName;
        this.location = location;
        this.wildlifeId = wildlifeId;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getWildlifeId() {
        return wildlifeId;
    }

    public int getId() {
        return id;
    }

    public Timestamp getTime() {
        return time;
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
