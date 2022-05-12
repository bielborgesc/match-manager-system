package domain.entities.round;

import domain.entities.match.Match;

import java.util.LinkedList;

public class Round {
    private int id;
    private LinkedList<Match> match;

    public Round(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Match> getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match.add(match);
    }
}
