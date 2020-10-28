package DAO;



import models.Endangered;

import java.util.List;

public interface Sql2oEndangered {
    List<Endangered> getAllEndangeredAnimals();

    void saveAgeOfAnimal(String age);

    void saveHealthOfAnimal(String health);

}
