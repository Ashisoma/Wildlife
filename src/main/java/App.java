import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DAO.*;
import models.Animal;
import models.Endangered;
import models.Sightings;
import models.Wildlife;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("WE ARE ON");

        staticFileLocation("/public");

        //String connectionString = "jdbc:h2:~/Wildlife.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        //String connectionString = "jdbc:postgresql://ec2-52-71-55-81.compute-1.amazonaws.com:5432/drmtbhcoiev0d";
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife";
        //Sql2o sql2o = new Sql2o(connectionString, "yxezrizrnsgbzx", "3f04c3ed6717068d1037f413fd74c017d3f7a4ff6a2058a2494805d2784ae2c9");
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "Access");
        Sql2oAnimalDAO sql2oAnimalDAO = new Sql2oAnimalDAO(sql2o);
        SightingsDAO sightingsDAO = new SightingsDAO(sql2o);
        EndangeredDAO endangeredDAO = new EndangeredDAO(sql2o);
        WildlifeDAO wildlifeDAO = new WildlifeDAO(sql2o);


        Map<String, Object> model = new HashMap<>();

        Wildlife animal = new Endangered ("hippo", "endangered","ill","young");
        System.out.println(animal.getAnimalName());

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
               // Animal animal = new Animal(name);
                sql2oAnimalDAO.addAnimalName(name);
                //wildlifeDAO.addAnimalName(animal);
            } else {
                //Endangered endangered = new Endangered(name);
                endangeredDAO.addAnimalName(name);
                //wildlifeDAO.addAnimalName(endangered);
                endangeredDAO.saveHealthOfAnimal(health);
                endangeredDAO.saveAgeOfAnimal(age);
            }
            Sightings sightings = new Sightings(location, ranger, animalId);
            sightingsDAO.addSightings(sightings);
            response.redirect("/all-animals");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/all-animals", (request, response) -> {
            //System.out.println(endangeredDAO.getAllEndangeredAnimals());
            model.put("animals", endangeredDAO.getAllEndangeredAnimals());
            //model.put("animals", wildlifeDAO.getAllWildlife());
           // model.put("wildlife", sql2oAnimalDAO.getAllAnimals());
            model.put("common",sql2oAnimalDAO.getAllAnimals());

            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        get("/sightings", (request, response) -> {
            model.put("sight", sightingsDAO.getAllSightings());
            return new ModelAndView(model, "sightings.hbs");
        }, new HandlebarsTemplateEngine());
    }

}

