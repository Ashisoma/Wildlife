package models;

import java.util.Objects;

public abstract class Wildlife {
    public int id;
    public String name;
    public String type;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wildlife wildlife = (Wildlife) o;
        return name.equals(wildlife.name) &&
                type.equals(wildlife.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
