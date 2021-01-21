
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerModel {
    private static ServerSocket serverSocket;
    private static Socket client;
    private static ObjectInputStream ois;
    private static ObjectOutputStream oos;
    private static ArrayList<User> users = new ArrayList();
    private static ArrayList<Game> games = new ArrayList<>();

    public ServerModel() {

    }

    public static void main(String[] args) {
        ServerUI ui = new ServerUI();
        ui.start();
        initializeUI(ui);
    }

    private static void initializeUI(ServerUI ui) {
        ui.getStartServerButton().addActionListener((e) -> {
            startServer();
        });
    }

    private static void getUserList() {
        Scanner scanner = new Scanner("Files\\user_file.txt");
        while(scanner.hasNextLine()) {
            if(scanner.nextLine().equals(""))
                return;
            String userInfo = scanner.nextLine();
            String[] userSplit = userInfo.split(" ");
            String username = userSplit[0];
            String password = userSplit[1];
            User user = new User(username, password);
            user.loadData();
            users.add(user);
        }

    }

    private static void startServer() {
        try {
            serverSocket = new ServerSocket(1212);


            while(true) {
                client = serverSocket.accept();
                System.out.println("new client connected");
                ois = new ObjectInputStream(client.getInputStream());
                oos = new ObjectOutputStream(client.getOutputStream());

                while(true) {
                    String req = ois.readUTF();
                    System.out.println("client says: " + req);
                    ois.close();
                    if (req.equals("exit")) {
                        break;
                    }
                    ServerHandler.handle(req, oos);
                }
            }
        } catch (Exception var1) {
            System.out.println("an error was found");
        }
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
    public static ArrayList<Game> getGames()
    {
        return games;
    }
}
