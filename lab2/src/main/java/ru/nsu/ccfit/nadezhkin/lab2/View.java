package ru.nsu.ccfit.nadezhkin.lab2;

import javax.swing.*;
import java.util.concurrent.BlockingQueue;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class View implements Runnable {
    private final int X_field = 16;
    private final int Y_field = 10;
    private final int X_size = 10*40+16 + 4*25+6;
    private final int Y_size = 16*40+35;
    private final int X_location = 500;
    private final int Y_location = 200;
    private final int ZERO = 0;
    private Color[][] colors;
    private BlockingQueue<Message> controllerToViewQueue;
    private BlockingQueue<Message> viewToControllerQueue;
    private Panel panel;
    private JFrame frame;
    private Message message;
    private boolean game_over = false;

    public View() {
        frame = new JFrame("Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(X_size, Y_size);
        frame.setVisible(true);
        frame.setLocation(X_location, Y_location);
        frame.setResizable(false);

        colors = new Color[X_field][Y_field];
        for (int i = ZERO; i < X_field; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                colors[i][j] = Color.DARK_GRAY;
            }
        }

        panel = new Panel(colors);
        frame.add(panel);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        message = new Message(Message.TYPE.ROTATE_LEFT);
                        try {
                            viewToControllerQueue.put(message);
                        }
                        catch (InterruptedException exc) {
                        }
                        break;
                    case KeyEvent.VK_DOWN:
                        message = new Message(Message.TYPE.ROTATE_RIGHT);
                        try {
                            viewToControllerQueue.put(message);
                        }
                        catch (InterruptedException exc) {
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        message = new Message(Message.TYPE.MOVE_LEFT);
                        try {
                            viewToControllerQueue.put(message);
                        }
                        catch (InterruptedException exc) {
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        message = new Message(Message.TYPE.MOVE_RIGHT);
                        try {
                            viewToControllerQueue.put(message);
                        }
                        catch (InterruptedException exc) {
                        }
                        break;
                    case KeyEvent.VK_SPACE:
                        message = new Message(Message.TYPE.FASTER);
                        try {
                            viewToControllerQueue.put(message);
                        }
                        catch (InterruptedException exc) {
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (game_over) {
                            game_over = false;
                            panel.setGame_over(game_over);
                            message = new Message(Message.TYPE.RESTART);
                            try {
                                viewToControllerQueue.put(message);
                            }
                            catch (InterruptedException exc) {
                            }
                        }
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void run() {
        try {
            loop();
        }
        catch (Exception e) {
        }
    }

    private void loop() throws InterruptedException {
        Message message;
        while (true) {
            message = controllerToViewQueue.take();
            if (message == null) {
                continue;
            }
            switch (message.getType()) {
                case REDRAW:
                    redraw(message.getData());
                    break;
                case CHANGE_NEXT:
                    panel.setNext(message.getAdd());
                    break;
                case SCORE_UPDATE:
                    panel.setScore(message.getAdd());
                    break;
                case GAME_OVER:
                    game_over = true;
                    panel.setGame_over(game_over);
                    panel.redraw();
                    break;
                default:
                    break;
            }
        }
    }

    public void setControllerToViewQueue(BlockingQueue<Message> c) {
        controllerToViewQueue = c;
    }

    public void setViewToControllerQueue(BlockingQueue<Message> v) {
        viewToControllerQueue = v;
    }

    public void redraw(int[][] field) {
        for (int i = ZERO; i < X_field; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                switch (field[i][j]) {
                    case 0:
                        colors[i][j] = Color.GRAY;
                        break;
                    case 1:
                        colors[i][j] = Color.RED;
                        break;
                    case 2:
                        colors[i][j] = Color.GREEN;
                        break;
                    case 3:
                        colors[i][j] = Color.BLUE;
                        break;
                    case 4:
                        colors[i][j] = Color.YELLOW;
                        break;
                    case 5:
                        colors[i][j] = Color.ORANGE;
                        break;
                    case 6:
                        colors[i][j] = Color.PINK;
                        break;
                    case 7:
                        colors[i][j] = Color.CYAN;
                        break;
                }
            }
        }
        panel.redraw(colors);
    }
}
