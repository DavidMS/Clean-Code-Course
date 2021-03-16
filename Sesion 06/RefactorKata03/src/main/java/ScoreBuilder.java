public class ScoreBuilder {

    private static final int DEUCE_THRESHOLD = 3;
    private static final String FORTY_POINT = "Forty";
    private static final String THIRTY_POINT = "Thirty";
    private static final String FIFTEEN_POINT = "Fifteen";
    private static final String LOVE_POINT = "Love";
    private static final String DEUCE = "Deuce";
    private static final String TIE_SUFFIX = "All";
    private static final String SEPARATOR = "-";

    private int playerOnePoints;
    private int playerTwoPoints;

    public ScoreBuilder(int playerOnePoints, int playerTwoPoints) {
        this.playerOnePoints = playerOnePoints;
        this.playerTwoPoints = playerTwoPoints;
    }

    public String getScore() {
        if (playerOnePoints == playerTwoPoints) {
            if(playerOnePoints >= DEUCE_THRESHOLD)
                return DEUCE;

            return pointsToString(playerOnePoints) + SEPARATOR + TIE_SUFFIX;
        }

        return pointsToString(playerOnePoints) + SEPARATOR + pointsToString(playerTwoPoints);
    }

    private String pointsToString(int points) {
        if (points == 0)
            return LOVE_POINT;
        if (points == 1)
            return FIFTEEN_POINT;
        if (points == 2)
            return THIRTY_POINT;
        if (points == 3)
            return FORTY_POINT;
        return "";
    }

}