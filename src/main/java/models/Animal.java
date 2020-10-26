package models;

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
}
