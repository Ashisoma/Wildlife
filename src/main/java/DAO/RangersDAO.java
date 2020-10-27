package DAO;

import models.Animal;
import models.Endangered;
import models.Rangers;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class RangersDAO implements Sql2oRangers {

    private final Sql2o sql2o;

    public RangersDAO(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public List<Rangers> getAllRanges() {
        String sql = "SELECT * FROM rangers";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Rangers.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }
    @Override
    public void addRanger(Rangers rangers) {
        String sql = "INSERT INTO rangers (rangerName, badge, contact) VALUES (:rangerName, :badge, :contact)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(rangers).executeUpdate().getKey();
            rangers.getRangersId();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public Rangers getRangerByID(int id) {
        String sql = "SELECT * FROM rangers WHERE id=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Rangers.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public List<Animal> getRangersAnimalSightings(int id) {
        String sql = "SELECT * FROM animals WHERE rangerId=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Animal.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }
    @Override
    public List<Endangered> getRangersEndangeredSightings(int id) {
        String sql = "SELECT * FROM endangeredAnimals WHERE rangerId=:id";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Endangered.class);
        } catch (Sql2oException ex) {
            System.out.println(ex);
            return null;
        }
    }


}
