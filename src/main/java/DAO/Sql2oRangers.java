package DAO;

import models.Animal;
import models.Endangered;
import models.Rangers;

import java.util.List;

public interface Sql2oRangers {
    List<Rangers> getAllRanges();

    void addRanger(Rangers rangers);

    Rangers getRangerByID(int id);

     List<Animal> getRangersAnimalSightings(int id);

    List<Endangered> getRangersEndangeredSightings(int id);
}
