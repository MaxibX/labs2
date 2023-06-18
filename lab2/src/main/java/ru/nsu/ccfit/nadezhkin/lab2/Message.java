package ru.nsu.ccfit.nadezhkin.lab2;

public class Message {
    public static enum TYPE {REDRAW, CHANGE_NEXT, SCORE_UPDATE, GAME_OVER, MOVE_LEFT, MOVE_RIGHT, FASTER, ROTATE_LEFT, ROTATE_RIGHT, RESTART};
    private TYPE type;
    private int add_info;
    private int[][] data;
    public Message(TYPE t) {
        type = t;
        add_info = 0;
    }
    public Message(TYPE t, int a) {
        type = t;
        add_info = a;
    }
    public Message(TYPE t, int[][] d) {
        type = t;
        data = d;
    }
    public TYPE getType() {
        return type;
    }
    public int getAdd() {
        return add_info;
    }
    public int[][] getData() {
        return data;
    }
}
