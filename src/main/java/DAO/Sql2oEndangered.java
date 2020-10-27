package DAO;



import models.Endangered;

import java.util.List;

public interface Sql2oEndangered {
    List<Endangered> getAllEndangeredAnimals();

    void addEndangeredAnimal(Endangered endangered);

    Endangered getEndangeredAnimalById(int id);
}
