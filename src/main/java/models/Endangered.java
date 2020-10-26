package models;

public class Endangered {
    private String dangerName;
    private int id;
    private int age;
    private String health;

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

    public Endangered(String dangerName, int age, String health) {
        this.dangerName = dangerName;
        this.age = age;
        this.health = health;
    }

    public void addAnimalBYRanger(){

    }

    public void getAnimalbyId(){

    }

    public void getAnimallocation(){}

}
