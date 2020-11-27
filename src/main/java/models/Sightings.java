package models;

import DB.DB;
import org.sql2o.Connection;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class Sightings {
    private int id;
    private String location;
    private String rangerName;
    private int wildlifeId;
    private Timestamp time;

    public Sightings(String location, String rangerName, int wildlifeId) {
        this.location = location;
        this.rangerName = rangerName;
        this.wildlifeId = wildlifeId;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public int getWildlifeId() {
        return wildlifeId;
    }

    public void save(){
        try(Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sightings(location, rangerName, wildlifeId, time) VALUES(:location, :rangerName,:wildlifeId, now())";
            this.id =(int) con.createQuery(sql,true)
                    .addParameter("location",this.location)
                    .addParameter("ranger_name",this.rangerName)
                    .addParameter("wildlife_id", this.wildlifeId)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Sightings> all(){
        String querySightings = "SELECT * FROM sightings";
        try (Connection con =DB.sql2o.open()){
            return con.createQuery(querySightings)
                    .executeAndFetch(Sightings.class);
        }
    }

    public Timestamp getTime() { return time; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sightings sightings = (Sightings) o;
        return wildlifeId == sightings.wildlifeId &&
                Objects.equals(location, sightings.location) &&
                Objects.equals(rangerName, sightings.rangerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, rangerName, wildlifeId);
    }
}

