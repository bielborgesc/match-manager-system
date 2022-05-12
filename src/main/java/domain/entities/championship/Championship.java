package domain.entities.championship;

import domain.entities.team.Team;

import java.util.Date;
import java.util.HashMap;

public class Championship {

    private int id;
    private String name;
    private Date date;
    private HashMap<Integer, Team> teams;
    private TypeEnum typeEnum;
    private CategoryEnum categoryEnum;
    //TODO rodadas;


    public Championship(int id, String name, Date date, TypeEnum typeEnum, CategoryEnum categoryEnum) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.typeEnum = typeEnum;
        this.categoryEnum = categoryEnum;
    }

    public Championship(int id, String name, Date date, HashMap<Integer, Team> teams, TypeEnum typeEnum, CategoryEnum categoryEnum) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.teams = teams;
        this.typeEnum = typeEnum;
        this.categoryEnum = categoryEnum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Team getTeam(Integer id) {
        return this.teams.get(id);
    }

    public void setTeam(Team team) {
        this.teams.put(team.getId(), team);
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public void setCategoryEnum(CategoryEnum categoryEnum) {
        this.categoryEnum = categoryEnum;
    }

}
