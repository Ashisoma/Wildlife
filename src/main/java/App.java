import java.util.HashMap;
import java.util.Map;

import DAO.*;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        System.out.println("WE ARE ON");

        String connectionString = "jdbc:postgresql://localhost:5432/wildlife";
        Sql2o sql2o = new Sql2o(connectionString,"moringa","Access");
        Sql2oAnimalDAO sql2oAnimalDAO = new Sql2oAnimalDAO(sql2o);
        SightingsDAO sightingsDAO = new SightingsDAO(sql2o);
        EndangeredDAO endangeredDAO = new EndangeredDAO(sql2o);
        WildlifeDAO wildlifeDAO = new WildlifeDAO(sql2o);



        Map<String, Object> model = new HashMap<>();

        get("/",(req, res)->{
            model.put("endangered",endangeredDAO.getAllEndangeredAnimals());
            model.put("nomarls", sql2oAnimalDAO.getAllAnimals());
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    }
}
