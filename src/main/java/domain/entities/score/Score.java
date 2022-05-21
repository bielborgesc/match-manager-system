package domain.entities.score;

public class Score {
    private int idTeam;
    private int wins;
    private int loses;
    private int even;

    public Score(int idTeam) {
        this.idTeam = idTeam;
        wins = 0;
        loses = 0;
        even = 0;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public int getWinds() {
        return wins;
    }

    public void setWins() {
        this.wins += 1;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses() {
        this.loses += 1;
    }

    public int getEven() {
        return even;
    }

    public void setEven() {
        this.even += 1;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Classification: ");
        sb.append("winds = ").append(wins);
        sb.append(", loses = ").append(loses);
        sb.append(", even = ").append(even);
        return sb.toString();
    }
}
