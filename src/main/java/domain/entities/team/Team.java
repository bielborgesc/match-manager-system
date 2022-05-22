package domain.entities.team;

import domain.entities.score.Score;
import domain.entities.player.Player;
import domain.entities.player.StatusEnum;

import java.util.HashMap;

public class Team {
    private int Id;
    private String name;
    private Score score;
    private HashMap<String, Player> players = new HashMap<String, Player>();

    public Team(int id, String name) {
        Id = id;
        this.name = name;
    }

    public Team(int id, String name, HashMap<String, Player> players) {
        Id = id;
        this.name = name;
        this.players = players;
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

    public Player getPlayers(String cpf) {
        return this.players.get(cpf);
    }

    public void addPlayer(Player player) {
        players.put(player.getCpf(), player);
        player.setStatus(StatusEnum.UNAVAILABLE);
        this.players.put(player.getCpf(), player);
    }

    public void removePlayer(Player player) {
        players.remove(player.getCpf(), player);
        player.setStatus(StatusEnum.AVAILABLE);
        this.players.remove(player.getCpf(), player);
    }
}
