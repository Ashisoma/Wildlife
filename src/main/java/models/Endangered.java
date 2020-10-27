package models;

public class Endangered {
    private String dangerName;
    private int id;
    private int age;
    private String health;
    private int locationId;
    private int rangerId;

    public Endangered(String dangerName, int age, String health, int locationId, int rangerId) {
        this.dangerName = dangerName;
        this.age = age;
        this.health = health;
        this.locationId = locationId;
        this.rangerId = rangerId;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getRangerId() {
        return rangerId;
    }

    public void setRangerId(int rangerId) {
        this.rangerId = rangerId;
    }

    public String getDangerName() {
        return dangerName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }


    public void addAnimalBYRanger(){

    }

    public void getAnimalbyId(){

    }

    public void getAnimallocation(){}

}
