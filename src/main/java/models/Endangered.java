package models;

public class Endangered extends Wildlife{
    //private int id;
    private String health;
    private String age;

    public static final String HEALTHY ="healthy";
    public static final String OKAY ="okay";
    public static final String ILL ="ill";
    public static final String NEWBORN ="newborn";
    public static final String YOUNG ="young";
    public static final String ADULT ="adult";

    private static final String DATABASE_TYPE = "endangered";

    public Endangered(String animalName, String type, String health, String age) {
        super(animalName, type);
        this.health = health;
        this.age = age;
        this.setType(DATABASE_TYPE);
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
