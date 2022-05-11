package domain.entities.classification;

public class Classification {
    private int wins;
    private int loses;
    private int even;

    public Classification() {
        wins = 0;
        loses = 0;
        even = 0;
    }

    public int getWinds() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins += wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses += loses;
    }

    public int getEven() {
        return even;
    }

    public void setEven(int even) {
        this.even += even;
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
