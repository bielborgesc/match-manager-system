package domain.entities.match;

import domain.entities.team.Team;

public class Match {
    private int id;
    private Team teamA;
    private Team teamB;
    private int teamPointsA;
    private int teamPointsB;

    public Match(Team teamA, Team teamB) {
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

    public int getTeamPointsA() {
        return teamPointsA;
    }

    public int getTeamPointsB() {
        return teamPointsB;
    }

    public void setTeamPoints(int teamPointsA, int teamPointsB) {
        this.teamPointsA = teamPointsA;
        this.teamPointsB = teamPointsB;
        this.setScore();
    }

    public void setScore(){
//        this.teamPointsA > this.teamPointsB ? this.teamA.addWins() this.teamB.addLoser() :
//                this.teamPointsA < this.teamPointsB ? this.teamA.addLoser(), this.teamB.addWins() :
//                this.teamPointsA == this.teamPointsB ? this.teamA.addEven(), this.teamB.addEven();
        if(this.teamPointsA > this.teamPointsB){
            this.teamA.addWins();
            this.teamB.addLoser();
        } else if(this.teamPointsA < this.teamPointsB){
            this.teamA.addLoser();
            this.teamB.addWins();
        } else {
            this.teamA.addEven();
            this.teamB.addEven();
        }
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
