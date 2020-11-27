package models;

public class Endangered extends Wildlife{
    private String age;
    private String health;

    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    private static final String DATABASE_TYPE = "endangered";

    public Endangered(String age, String health, String name) {
        this.type = DATABASE_TYPE;
        this.name = name;
        this.age = age;
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public static String getDatabaseType() {
        return DATABASE_TYPE;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
