package domain.entities.match;

import domain.entities.team.Team;

public class Match {
    private Team teamA;
    private Team teamB;
    private int Apoints;
    private int Bpoits;

    public Match(Team teamA, Team teamB, int apoints, int bpoits) {
        this.teamA = teamA;
        this.teamB = teamB;
        Apoints = apoints;
        Bpoits = bpoits;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public int getApoints() {
        return Apoints;
    }

    public void setApoints(int apoints) {
        Apoints = apoints;
    }

    public int getBpoits() {
        return Bpoits;
    }

    public void setBpoits(int bpoits) {
        Bpoits = bpoits;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Match: ");
        sb.append("teamA=").append(teamA);
        sb.append(", teamB=").append(teamB);
        sb.append(", Apoints=").append(Apoints);
        sb.append(", Bpoits=").append(Bpoits);
        sb.append('}');
        return sb.toString();
    }
}
