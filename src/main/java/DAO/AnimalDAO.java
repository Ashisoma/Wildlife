package DAO;

import models.Animal;

import java.util.List;

public interface AnimalDAO {
    List<Animal> getAllAnimals();

    void addAnimal(Animal animal);

    Animal getAnimalById(int id);
}
