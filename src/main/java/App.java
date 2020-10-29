import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.*;
import models.Animal;
import models.Endangered;
import models.Sightings;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("WE ARE ON");

        staticFileLocation("/public");

        String connectionString = "jdbc:h2:~/Wildlife.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        //String connectionString = "jdbc:postgresql://localhost:5432/wildlife";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
       // Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");
        Sql2oAnimalDAO sql2oAnimalDAO = new Sql2oAnimalDAO(sql2o);
        SightingsDAO sightingsDAO = new SightingsDAO(sql2o);
        EndangeredDAO endangeredDAO = new EndangeredDAO(sql2o);
        WildlifeDAO wildlifeDAO = new WildlifeDAO(sql2o);


        Map<String, Object> model = new HashMap<>();


        get("/", (req, res) -> {
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());


        get("/add-wildlife", (request, response) -> {
            return new ModelAndView(model, "wildlife.hbs");
        }, new HandlebarsTemplateEngine());


        post("/add-wildlife", (request, response) -> {
            int animalId = Integer.parseInt(request.queryParams("animalId"));
            String location = request.queryParams("location");
            String name = request.queryParams("name");
            String ranger = request.queryParams("ranger");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            if (age == null && health == null) {
                Animal animal = new Animal(name);
               // sql2oAnimalDAO.addAnimal(animal);
                wildlifeDAO.addAnimalName(name);
            } else {
                Endangered endangered = new Endangered(name);
               // endangeredDAO.addEndangered(endangered);
                wildlifeDAO.addAnimalName(name);
                endangeredDAO.saveHealthOfAnimal(health);
                endangeredDAO.saveAgeOfAnimal(age);
            }
            Sightings sightings = new Sightings(location, ranger, animalId);
            sightingsDAO.addSightings(sightings);
            response.redirect("/all-animals");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/all-animals", (request, response) -> {
            model.put("sightings", sightingsDAO.getAllSightings());
            model.put("animals", sql2oAnimalDAO.getAllAnimals());
            model.put("endangeredAnimals", endangeredDAO.getAllEndangeredAnimals());
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            model.put("sightings", sightingsDAO.getAllSightings());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
    }


}

