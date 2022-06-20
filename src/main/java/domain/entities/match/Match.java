package domain.entities.match;

import domain.entities.team.Team;

public class Match {
    private int id;
    private Team teamA;
    private Team teamB;
    private int teamPointsA;
    private int teamPointsB;
    private int idRound;
    private boolean isFinished = false; // Realizada e não realizada

    public Match(int id, Team teamA, Team teamB) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public Match(int id, Team teamA, Team teamB, int idRound) {
        this.id = id;
        this.teamA = teamA;
        this.teamB = teamB;
        this.idRound = idRound;
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

    public int getIdRound() {
        return idRound;
    }

    public void setIdRound(int idRound) {
        this.idRound = idRound;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Match: ");
        sb.append("id: ").append(id).append('\n');
        sb.append(teamA.getName()).append(" X ");
        sb.append(teamB.getName()).append('\n');
        sb.append("teamPointsA = ").append(teamPointsA).append('\n');
        sb.append("teamPointsB = ").append(teamPointsB).append('\n');
        return sb.toString();
    }
}
