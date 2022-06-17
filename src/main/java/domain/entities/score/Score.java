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

    public void addWin() {
        this.wins += 1;
    }

    public int getLoses() {
        return loses;
    }

    public void addLose() {
        this.loses += 1;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public void setEven(int even) {
        this.even = even;
    }

    public void addEven() {
        this.even += 1;
    }

    public int getEven() {
        return even;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score: ").append("id: ").append(getIdTeam()).append("\n");
        sb.append("winds: ").append(wins).append("\n");
        sb.append("loses: ").append(loses).append("\n");
        sb.append("even: ").append(even).append("\n").append("\n");
        return sb.toString();
    }
}
