package domain.entities.score;

public class Score {
    private int idTeam;
    private int wins;
    private int loses;
    private int even;
    private int points;
    private final int winPoints = 10;
    private final int losePoints = 5;
    private final int evenPoints = 0;


    public Score(int idTeam) {
        this.idTeam = idTeam;
        wins = 0;
        loses = 0;
        even = 0;
        points = 0;
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
        this.points = this.points + winPoints;
    }

    public int getLoses() {
        return loses;
    }

    public void addLose() {
        this.loses += 1;
        this.points = this.points - losePoints;
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
        this.points = this.points + evenPoints;
    }

    public int getWins() {
        return wins;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getEven() {
        return even;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Score: ").append("id: ").append(getIdTeam()).append("\n");
        sb.append("winds: ").append(wins).append("\n");
        sb.append("loses: ").append(loses).append("\n");
        sb.append("even: ").append(even).append("\n");
        sb.append("points: ").append(points).append("\n");
        return sb.toString();
    }
}
