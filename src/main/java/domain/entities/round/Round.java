package domain.entities.round;

import domain.entities.match.Match;

import java.util.HashMap;

public class Round {
    private int id;
    private HashMap<Integer, Match> match;

    public Round(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMatch(Match match) {
        return match.getId();
    }

    public void setMatch(Match match) {
        this.match.put(match.getId(), match);
    }
}
