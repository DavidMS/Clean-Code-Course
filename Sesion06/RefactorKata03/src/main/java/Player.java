public class Player {

    private static final int WIN_DELTA_POINTS_THRESHOLD = 2;
    private static final int WIN_MIN_POINTS = 4;
    private static final int ADVANTAGE_THRESHOLD = 3;
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return this.name;
    }

    public boolean wins(Player player) {
        return (getPoints() >= WIN_MIN_POINTS && player.getPoints()>= 0 &&
                (getPoints() - player.getPoints())>= WIN_DELTA_POINTS_THRESHOLD);
    }

    public boolean hasAdvantage(Player player) {
        return (getPoints() > player.getPoints() &&
                player.getPoints() >= ADVANTAGE_THRESHOLD);
    }

    public int getPoints() {
        return points;
    }

    public void incPoints() {
        this.points++;
    }
}