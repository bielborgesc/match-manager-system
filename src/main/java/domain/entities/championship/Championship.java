package domain.entities.championship;

import domain.entities.modality.Modality;
import domain.entities.team.Team;

import java.util.Date;
import java.util.HashMap;

public class Championship {

    private int id;
    private String name;
    private Date date;

    private Modality modality;

    private HashMap<Integer, Team> teams;

    public Championship(int id, String name, Date date) {
        this.id = id;
        this.name = name;
        this.date = date;
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

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Team getTeam(Team team) {
        return this.teams.get(team.getId());
    }

    public void setTeam(Team team) {
        this.teams.put(team.getId(), team);
    }
}
