package game_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 507;
    private static final int WINDOW_WIDTH = 555;

    JButton btnStart, btnExit;
    Map map;
    SettingsWindow settings;


    GameWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("ИГРА В КРЕСТИКИ-НОЛИКИ");
        setResizable(false);

        map = new Map();
        settings = new SettingsWindow(this);
        btnExit = new JButton("ВЫХОД");
        btnStart = new JButton("НОВАЯ ИГРА");

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(map);

        setVisible(true);
    }

     void startNewGame(int mode, int fSzX, int fSzY, int wLen) {
        map.startNewGame(mode, fSzX, fSzY, wLen);
    }
}
