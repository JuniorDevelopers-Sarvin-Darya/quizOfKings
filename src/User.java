import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Game> games = new ArrayList();
    private boolean playsInfinity;
    private int activeGames;
    private File file;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.playsInfinity = false;
        this.activeGames = 0;
        this.file = new File("Files\\" + username + ".txt");
    }

    public void loadData() {
    }

    public int getActiveGames() {
        return this.activeGames;
    }

    public boolean playsInfinity() {
        return this.playsInfinity;
    }

    public String getUsername()
    {
        return username;
    }
}