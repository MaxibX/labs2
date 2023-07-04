package ru.nsu.ccfit.nadezhkin.lab2;

import java.awt.Point;
import java.util.Random;
import java.util.SortedSet;

import static java.lang.Math.abs;

public class Model {
    private final int X_field = 16;
    private final int Y_field = 10;
    private final int FOUR = 4;
    private final int ZERO = 0;
    private final int ONE = 1;
    private final int TWO = 2;
    private final int THREE = 3;
    private final int SEVEN = 7;
    private final int TEN = 10;
    private int[][] field;

    private int[][] field_figure = new int[X_field][Y_field];
    private int fShape;
    private int fRotation;
    private Point fPosition;
    private int next_figure;
    private int score;
    private SortedSet<Integer> scores;
    public boolean game_over;
    Random rand = new Random();

    public Model() {
        restart();
    }

    public void restart() {
        field = new int[X_field + TWO][Y_field];
        for (int i = ZERO; i < X_field + TWO; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                field[i][j] = ZERO;
            }
        }
        fShape = rand_figure();
        fRotation = ZERO;

        fPosition = new Point(FOUR, ZERO);
        next_figure = rand_figure();
        //scores.add(score);
        score = ZERO;
        game_over = false;
    }

    private int rand_figure() {
        return abs(rand.nextInt() % SEVEN) + ONE;
    }

    public void new_figure() {
        fPosition.x = FOUR;
        fPosition.y = ZERO;
        fShape = next_figure;
        next_figure = rand_figure();
    }

    public int get_next() {
        return next_figure;
    }

    public int get_score() {
        return score;
    }
    public void add_score(int a) {
        scores.add(a);
    }
    public SortedSet<Integer> get_scores() {
        return scores;
    }

    public boolean is_fall_enable() {
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y >= X_field + ONE) {
                return false;
            }
            if (field[fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y + ONE][fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x] != ZERO) {
                return false;
            }
        }
        return true;
    }

    public boolean is_left_enable() {
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x <= ZERO) {
                return false;
            }
            if (field[fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y][fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x - ONE] != ZERO) {
                return false;
            }
        }
        return true;
    }

    public boolean is_right_enable() {
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x >= Y_field - ONE) {
                return false;
            }
            if (field[fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y][fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x + ONE] != ZERO) {
                return false;
            }
        }
        return true;
    }

    public boolean is_right_rotate_enable() {
        int nextPos = fRotation - ONE;
        if (nextPos < ZERO) {
            nextPos = THREE;
        }
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.x + Figures.FiguresArray[fShape-1][nextPos][i].x > Y_field - ONE) {
                return false;
            }
            if (field[fPosition.y + Figures.FiguresArray[fShape-1][nextPos][i].y][fPosition.x + Figures.FiguresArray[fShape-1][nextPos][i].x]!=0) {
                return false;
            }
        }
        return true;
    }

    public boolean is_left_rotate_enable() {
        int nextPos = (fRotation + ONE) % FOUR;
        for (int i = ZERO; i < FOUR; ++i) {
            if(fPosition.x + Figures.FiguresArray[fShape-1][nextPos][i].x > 9) {
                return false;
            }
            if(field[fPosition.y + Figures.FiguresArray[fShape-1][nextPos][i].y][fPosition.x + Figures.FiguresArray[fShape-1][nextPos][i].x]!=0) {
                return false;
            }
        }
        return true;
    }

    public void move_right() {
        fPosition.x++;
    }
    public void move_left() {
        fPosition.x--;
    }

    public void move_down() {
        fPosition.y++;
    }

    public void rotate_right() {
        fRotation = (fRotation + ONE) % FOUR;
    }

    public void rotate_left() {
        if (fRotation == ZERO) fRotation = THREE;
        else fRotation = (fRotation - ONE) % FOUR;
    }

    public boolean remove_full_lines() {
        boolean is_line_full = true;
        int lines = ZERO, line_score = TEN;

        for (int i = TWO; i < X_field + TWO; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                if (field[i][j] == ZERO) {
                    is_line_full = false;
                    break;
                }
            }
            if (!is_line_full) {
                is_line_full = true;
                continue;
            }
            ++lines;
            for (int j = ZERO; j < Y_field; ++j) {
                for (int k = i; k >= TWO; --k) {
                    field[k][j] = field[k - ONE][j];
                }
            }
        }
        for (int i = ZERO; i < lines; ++i) {
            score += line_score;
            line_score *= TWO;
        }
        return lines != ZERO;
    }
    public boolean is_end() {
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y < TWO) {
                return true;
            }
        }
        return false;
    }
    public void figure_copy() {
        for (int i = ZERO; i < FOUR; ++i) {
            field[fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y][fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x] = fShape;
        }
    }

    public int[][] get_data() {
        for (int i = ZERO; i < X_field; ++i) {
            for (int j = ZERO; j < Y_field; ++j) {
                field_figure[i][j] = field[i + TWO][j];
            }
        }
        for (int i = ZERO; i < FOUR; ++i) {
            if (fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y - TWO >= ZERO) {
                field_figure[fPosition.y + Figures.FiguresArray[fShape - ONE][fRotation][i].y - TWO][fPosition.x + Figures.FiguresArray[fShape - ONE][fRotation][i].x] = fShape;
            }
        }
        return field_figure;
    }
}
