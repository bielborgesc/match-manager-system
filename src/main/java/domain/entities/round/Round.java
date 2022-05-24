package domain.entities.round;

import domain.entities.match.Match;

import java.util.LinkedHashMap;

public class Round {
    private int id;
    private LinkedHashMap<Integer, Match> arrMatch = new LinkedHashMap<Integer, Match>();

    public Round(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedHashMap<Integer, Match> getAllMatch() {
        return arrMatch;
    }

    public boolean addNewMatch(Match match) {
        this.arrMatch.put(match.getId(), match);
        return true;
    }

    @Override
    public String toString() {
        return "Round{" +
                "id=" + id +
                ", arrMatch=" + arrMatch +
                '}';
    }
}
