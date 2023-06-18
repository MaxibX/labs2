package ru.nsu.ccfit.nadezhkin.lab2;

import javax.swing.*;
import java.awt.*;
import java.util.SortedSet;

public class Panel extends JPanel {
    private final int X_field = 16;
    private final int Y_field = 10;
    private int ONE = 1;
    private int FOUR = 4;
    private int ZERO = 0;
    private int TWO = 2;
    private int rect_field = 40;
    private int rect_next = 25;
    private int rect_next_pos_x = 400;
    private int rect_next_pos_y = 30;
    private int rect_next_step = 20;
    private int rect_window_x = 522;
    private int rect_window_y = 40*16;
    private int score_y_1 = 200;
    private int score_y_2 = 230;
    private int game_over_x_1 = 50;
    private int game_over_x_2 = 145;
    private int game_over_y_1 = 300;
    private int game_over_y_2 = 350;
    private int font_1_size = 18;
    private int font_2_size = 70;

    private Color[][] colors;
    private int nextShape;
    private int score;
    private SortedSet<Integer> scores;
    private Font font1 = new Font("Dialog", Font.BOLD, font_1_size);
    private Font font2 = new Font("Dialog", Font.BOLD, font_2_size);
    private boolean game_over = false;

    public Panel(Color[][] colors) {
        this.colors = colors;
        repaint();
    }

    public void setGame_over(boolean game_over) {
        this.game_over = game_over;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNext(int next) {
        this.nextShape = next;
    }

    public void redraw() {
        repaint();
    }

    public void redraw(Color[][] colors) {
        this.colors = colors;
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(ZERO, ZERO, rect_window_x, rect_window_y);

        for (int i = ZERO; i < X_field; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                g.setColor(colors[i][j]);
                g.fillRect(rect_field*j, rect_field*i, rect_field - TWO, rect_field - TWO);
            }
        }

        for (int i = ZERO; i < FOUR; ++i) {
            for (int j = ZERO; j < FOUR; ++j) {
                g.setColor(NextFigures.FiguresList[nextShape - ONE][i][j]);
                g.fillRect(rect_next_pos_x + rect_next * j, rect_next_pos_y + rect_next * i, rect_next - TWO, rect_next - TWO);
            }
        }

        g.setFont(font1);
        g.setColor(Color.WHITE);
        g.drawString("SCORE", rect_next_pos_x + rect_next_step, score_y_1);
        g.drawString("" + score, rect_next_pos_x + TWO * rect_next_step, score_y_2);

        if (game_over) {
            g.setFont(font2);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER", game_over_x_1, game_over_y_1);
            g.setFont(font1);
            g.drawString("Press Enter to play again", game_over_x_2, game_over_y_2);
        }
    }
}
