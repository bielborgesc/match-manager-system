package domain.entities.team;

import java.util.Arrays;

public class Team {
    private int Id;
    private String name;

    public Team(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer().append('\n');
        sb.append("Id: ").append(Id).append('\n');
        sb.append("name: ").append(name).append('\n');
        return sb.toString();
    }
}
