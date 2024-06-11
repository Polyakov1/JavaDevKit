package server;

import javax.swing.*;
import java.awt.*;



public class ServerWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 340;
    private static final int WINDOW_WIDTH = 350;
    private static final int WINDOW_POS_X = 300;
    private static final int WINDOW_POS_Y = 100;

    private final JTextField loginField = new JTextField(" Login ");

    ServerWindow(){
        setTitle("Join to Server");
        setBounds(WINDOW_POS_X, WINDOW_POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel grid = new JPanel(new GridLayout(3, 2));
        grid.add(loginField);

        JTextField passwordField = new JPasswordField("  Password ");
        grid.add(passwordField);

        JTextField serverField = new JTextField(" Address Server ");
        grid.add(serverField);

        JTextField portField = new JTextField("  Port ");
        grid.add(portField);

        JTextField forgotP = new JTextField("  Forgot Password? ");
        grid.add(forgotP);

        JButton buttonConnect = new JButton("Connect");
        grid.add(buttonConnect);

        add(grid);
        buttonConnect.addActionListener(e -> {
            String login = loginField.getText().trim();
            new ClientGUI(login);
        });

        setVisible(true);
    }
}