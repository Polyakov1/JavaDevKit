package game_window;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsWindow extends JFrame {
    public static final String BTN_START = "НАЧАТЬ НОВУЮ ИГРУ";
    public static final String LABEL_MODE = "ВЫБЕРИТЕ РЕЖИМ ИГРЫ";
    public static final String BTN_HUMAN_AI = "ЧЕЛОВЕК ПРОТИВ КОМПЬЮТЕРА";
    public static final String BTN_HUMAN_HUMAN = "ЧЕЛОВЕК ПРОТИВ ЧЕЛОВЕКА";
    public static final String SIZE_PREFIX = "УСТАНОВЛЕННЫЙ РАЗМЕР ПОЛЯ";
    public static final String LABEL_CHOICE_SIZE = "ВЫБЕРИТЕ РАЗМЕРЫ ПОЛЯ";
    public static final String LABEL_CHOICE_WING_LENGH = "ВЫБЕРИТЕ ДЛИНУ ДЛЯ ПОБЕДЫ";

    private static final int MODE_HA = 0;
    private static final int MODE_HH = 1;

    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 10;

    private static final int WINDOW_WIDTH = 230;
    private static final int WINDOW_HEIGHT = 350;

    JButton btnStart;
    JRadioButton humanHuman, humanAI;
    Label labelCurSize, labelWinLength;
    JSlider sizeSlider, winSlider;
    GameWindow gameWindow;

    SettingsWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        int centerGameWindowX = gameWindow.getX() + gameWindow.getWidth() / 2;
        int centerGameWindowY = gameWindow.getY() + gameWindow.getHeight() / 2;
        setLocation(centerGameWindowX - WINDOW_WIDTH / 2, centerGameWindowY - WINDOW_HEIGHT / 2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        add(createMainPanel());
        add(createButtonStart(), BorderLayout.SOUTH);
    }

    private Component createButtonStart() {
        btnStart = new JButton(BTN_START);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                startGame();
            }
        });
        return btnStart;
    }

    private Component createMainPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.add(createChoiceModePanel());
        panel.add(createChoiceSizePanel());
        panel.add(createChoiceWinLengthPanel());
        return panel;
    }

    private void startGame() {
        int mode;
        if (humanAI.isSelected()) {
            mode = MODE_HA;
        } else if (humanHuman.isSelected()) {
            mode = MODE_HH;
        } else {
            throw new RuntimeException("Unknown game mode");
        }
        int size = sizeSlider.getValue();
        int winLength = winSlider.getValue();
        gameWindow.startNewGame(mode, size, size, winLength);
    }

    private Component createChoiceModePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_MODE);
        ButtonGroup buttonGroup = new ButtonGroup();
        humanAI = new JRadioButton(BTN_HUMAN_AI);
        humanHuman = new JRadioButton(BTN_HUMAN_HUMAN);
        buttonGroup.add(humanAI);
        buttonGroup.add(humanHuman);
        humanAI.setSelected(true);

        panel.add(title);
        panel.add(humanAI);
        panel.add(humanHuman);
        return panel;
    }

    private Component createChoiceSizePanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_SIZE);
        labelCurSize = new Label(SIZE_PREFIX + MIN_SIZE);
        sizeSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int curSize = sizeSlider.getValue();
                labelCurSize.setText(SIZE_PREFIX + curSize);
                winSlider.setMaximum(curSize);
            }
        });

        panel.add(title);
        panel.add(labelCurSize);
        panel.add(sizeSlider);
        return panel;
    }

    private Component createChoiceWinLengthPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        Label title = new Label(LABEL_CHOICE_WING_LENGH);
        labelWinLength = new Label(SIZE_PREFIX + MIN_SIZE);
        winSlider = new JSlider(MIN_SIZE, MAX_SIZE, MIN_SIZE);
        winSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWinLength.setText(SIZE_PREFIX + winSlider.getValue());
            }
        });

        panel.add(title);
        panel.add(labelWinLength);
        panel.add(winSlider);
        return panel;
    }

}
