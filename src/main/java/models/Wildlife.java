package models;

import java.util.Objects;

public abstract class Wildlife {

    //public static int id;
    // public static int id;
    public   static  int id;
    private  String animalName;
    private  String type;

    public Wildlife(String animalName, String type) {
        this.animalName = animalName;
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public String getType() {
        return type;
    }

}
