

import java.awt.LayoutManager;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ServerUI {
    private JFrame mainFrame = new JFrame("Server");
    private JButton startServerButton = new JButton("Start Server");
    private JButton usersInfoButton = new JButton("User Info");

    public JButton getStartServerButton() {
        return this.startServerButton;
    }

    public JButton getUsersInfoButton() {
        return this.usersInfoButton;
    }

    public ServerUI() {
        this.mainFrame.setBounds(0, 0, 500, 500);
        this.mainFrame.setLayout((LayoutManager)null);
        this.startServerButton.setBounds(50, 0, 200, 200);
        this.usersInfoButton.setBounds(50, 200, 200, 200);
        this.mainFrame.add(this.startServerButton);
        this.mainFrame.add(this.usersInfoButton);
    }

    public void start() {
        this.mainFrame.setVisible(true);
    }
}
