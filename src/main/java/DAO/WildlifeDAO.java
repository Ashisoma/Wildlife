package DAO;

import models.Animal;
import models.Endangered;
import models.Wildlife;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class WildlifeDAO implements Sql2oWildlife  {

    private final Sql2o sql2o;

    public WildlifeDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void addAnimalName(String name) {
        try (Connection con = sql2o.open()) {
            String sql = "INSERT INTO animals(name, type) VALUES(:name,:type)";
            Wildlife.id = (int) con.createQuery(sql, true)
                    .addParameter("name", Wildlife.name)
                    .addParameter("type", Wildlife.type)
                    .throwOnMappingFailure(false)
                    .executeUpdate()
                    .getKey();

        }
    }

}
