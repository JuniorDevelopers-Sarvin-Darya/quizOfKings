import java.io.File;

public class Game {
    private User firstPlayer;
    private int firstUserScore;
    private User secondPlayer;
    private int secondUserScore;
    private static long id = 10000;
    private long gameId;
    private File gameFile;

    private Game(User firstPlayer, User secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.firstUserScore = 0;
        this.secondUserScore = 0;
        this.gameId = id++;
        this.gameFile = new File(gameId + ".txt");
    }

    public Game getGame(User firstPlayer, User secondPlayer) {
        if (this.isValidPlayer(firstPlayer) && this.isValidPlayer(secondPlayer)) {
            return new Game(firstPlayer, secondPlayer);
        } else {
            System.out.println("at least one of the players is invalid");
            return null;
        }
    }

    private boolean isValidPlayer(User player) {
        return player.getActiveGames() < 5 || player.playsInfinity();
    }
}
