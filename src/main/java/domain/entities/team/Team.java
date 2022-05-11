package domain.entities.team;

import domain.entities.classification.Classification;
import domain.entities.player.Player;

import java.util.LinkedList;

public class Team {
    private int Id;
    private String name;
    private Classification classification;
    private LinkedList<Player> players;

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

    public Classification getClassification() {
        return classification;
    }

    public void addWins(int countWin) {
        this.classification.setWins(countWin);
    }

    public void addLoser(int countLose) {
        this.classification.setLoses(countLose);
    }

    public void addWin(int countEven) {
        this.classification.setEven(countEven);
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Player player) {
        this.players.add(player);
    }
}
