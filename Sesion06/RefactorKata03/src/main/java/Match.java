public class Match {

    private Player winner = null;
    private Player advantage = null;

    private Player playerTwo;
    private Player playerOne;

    public Match(String player1Name, String player2Name) {
        this.playerOne = new Player(player1Name);
        this.playerTwo = new Player(player2Name);

    }

    public boolean hasWinner() {
        boolean thereIsWinner = playerOne.wins(playerTwo) || playerTwo.wins(playerOne);
        if(thereIsWinner)
            setWinner();
        return thereIsWinner;
    }

    public Player winnerPlayer() {
        return winner;
    }

    public boolean hasAdvantage() {
        boolean thereIsAdvantage = playerOne.hasAdvantage(playerTwo) || playerTwo.hasAdvantage(playerOne);
        if(thereIsAdvantage)
            setAdvantage();
        return thereIsAdvantage;
    }

    private void setAdvantage() {
        advantage = null;
        if(playerOne.hasAdvantage(playerTwo)) {
            advantage = playerOne;
        } else if (playerTwo.hasAdvantage(playerOne)) {
            advantage = playerTwo;
        }
    }

    public Player advantagePlayer() {
        return advantage;
    }

    public String getScore() {
        ScoreBuilder scoreBuilder = new ScoreBuilder(playerOne.getPoints(), playerTwo.getPoints());
        return scoreBuilder.getScore();
    }

    public void addPointTo(String player) {
        if(playerOne.getName().equals(player))
            playerOne.incPoints();
        else
            playerTwo.incPoints();
    }

    private void setWinner() {
        winner = null;
        if(playerOne.wins(playerTwo))
            winner = playerOne;
        else if(playerTwo.wins(playerOne))
            winner = playerTwo;
    }
}