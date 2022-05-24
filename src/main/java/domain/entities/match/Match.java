package domain.entities.match;

import domain.entities.team.Team;

public class Match {
    private int id;
    private Team teamA;
    private Team teamB;
    private int teamPointsA;
    private int teamPointsB;
    private boolean isFinished = false; // Realizada e não realizada

    public Match(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Match(int id, Team teamA, Team teamB) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Team getTeamA() {
        return teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeams(Team teamA, Team teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public int getTeamPointsA() {
        return teamPointsA;
    }

    public int getTeamPointsB() {
        return teamPointsB;
    }

    public void setTeamPoints(int teamPointsA, int teamPointsB) {
        this.teamPointsA = teamPointsA;
        this.teamPointsB = teamPointsB;
    }

    public boolean getStatus() {
        return this.isFinished;
    }

    public void setStatus(boolean bool) {
        this.isFinished = bool;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Match{");
        sb.append("id=").append(id);
        sb.append(", teamA=").append(teamA);
        sb.append(", teamB=").append(teamB);
        sb.append(", teamPointsA=").append(teamPointsA);
        sb.append(", teamPointsB=").append(teamPointsB);
        sb.append('}');
        return sb.toString();
    }
}
