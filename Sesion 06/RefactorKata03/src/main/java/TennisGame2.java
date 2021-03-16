public class TennisGame2 implements TennisGame
{
    private static final String ADVANTAGE_MESSAGE = "Advantage ";
    private static final String WIN_MESSAGE = "Win for ";
    private Match match;

    public TennisGame2(String playerOneName, String playerTwoName) {
        this.match = new Match(playerOneName, playerTwoName);
    }

    public String getScore(){
        if(match.hasWinner())
            return WIN_MESSAGE + match.winnerPlayer().getName();
        else if(match.hasAdvantage())
            return ADVANTAGE_MESSAGE + match.advantagePlayer().getName();

        return match.getScore();
    }

    public void wonPoint(String player) {
        match.addPointTo(player);
    }
}