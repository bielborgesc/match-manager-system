package domain.entities.championship;

import domain.entities.round.Round;
import domain.entities.team.Team;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Championship {

    private int id;
    private String name;
    private Date date;
    private LinkedHashMap<Integer, Round> rounds = new LinkedHashMap<>();
    private TypeEnum typeEnum;
    private CategoryEnum categoryEnum;


    public Championship(int id, String name, Date date, TypeEnum typeEnum, CategoryEnum categoryEnum) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public LinkedHashMap<Integer, Round> getRounds() {
        return rounds;
    }

    public void addRounds(Round round) {
        this.rounds.put(round.getId(), round);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Championship{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", date=").append(date);
        sb.append(", rounds=").append(rounds);
        sb.append(", typeEnum=").append(typeEnum);
        sb.append(", categoryEnum=").append(categoryEnum);
        sb.append('}');
        return sb.toString();
    }
}
