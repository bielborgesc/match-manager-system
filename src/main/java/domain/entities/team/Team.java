package domain.entities.team;

import domain.entities.score.Score;
import domain.entities.player.Player;
import domain.entities.player.StatusEnum;

import java.util.HashMap;

public class Team {
    private int Id;
    private String name;
    private Score score;

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

    public Score getClassification() {
        return score;
    }

    public void addWins() {
        this.score.setWins();
    }

    public void addLoser() {
        this.score.setLoses();
    }

    public void addEven() {
        this.score.setEven();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Team{");
        sb.append("Id=").append(Id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
