package models;

public class Endangered {
    private String dangerName;
    private int id;
    private int age;
    private String health;
    private int locationId;
    private int rangerId;


    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    public Endangered(String dangerName, int age, String health, int locationId, int rangerId) {
        this.dangerName = dangerName;
        this.age = age;
        this.health = health;
        this.locationId = locationId;
        this.rangerId = rangerId;

    }

    public String getDangerName() {
        return dangerName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getHealth() {
        return health;
    }
}
