package models;

import DB.DB;
import org.sql2o.Connection;

import java.util.ArrayList;
import java.util.List;

public class Rangers {
    private String rangerName;
    private int contact;
    private int badgeNumber;
    private int rangersId;

    public Rangers(String rangerName, int contact, int badgeNumber) {
        this.rangerName = rangerName;
        this.contact = contact;
        this.badgeNumber = badgeNumber;
    }

    public Rangers() {
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getContact() {
        return contact;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }


    public void getAllAnimalsByRangerId(){

    }
    public List<Object>  getAnimals(){
        List<Object> allAnimals = new ArrayList<Object>();
        try (Connection con = DB.sql2o.open()){
            String sqlAnimal = "SELECT * FROM animals where rangerId=:id;";
            List<Animal> animals = con.createQuery(sqlAnimal)
                    .addParameter("id", this.rangersId)
                    .executeAndFetch(Animal.class);
            allAnimals.addAll(animals);

            String sqlDanger = "SELECT * FROM endangeredanimal WHERE rangersId=:id;";
            List<Endangered> endangereds = con.createQuery(sqlDanger)
                    .addParameter("id", this.rangersId)
                    .executeAndFetch(Endangered.class);
            allAnimals.addAll(endangereds);
        }
        return allAnimals;
    }

}
