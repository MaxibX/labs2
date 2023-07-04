package ru.nsu.ccfit.nadezhkin.lab2;

import java.util.concurrent.BlockingQueue;
public class TimeController implements Runnable {
    private final int time = 500;
    private Model model;
    private BlockingQueue<Message> controllerToViewQueue;
    public void setModel(Model m) {
        model = m;
    }
    public void setControllerToViewQueue(BlockingQueue<Message> c) {
        this.controllerToViewQueue = c;
    }
    private void startTimer() throws InterruptedException {
        Message message;
        while (true) {
            if (model.game_over) {
                Thread.sleep(time);
                continue;
            }
            if (model.is_fall_enable()) {
                model.move_down();
            }
            else if (model.is_end()) {
                model.game_over = true;
                message = new Message(Message.TYPE.GAME_OVER);
                controllerToViewQueue.put(message);
            }
            else {
                model.figure_copy();
                model.new_figure();
                if (model.remove_full_lines()) {
                    message = new Message(Message.TYPE.SCORE_UPDATE, model.get_score());
                    controllerToViewQueue.put(message);
                }
                message = new Message(Message.TYPE.CHANGE_NEXT, model.get_next());
                controllerToViewQueue.put(message);
            }
            message = new Message(Message.TYPE.REDRAW, model.get_data());
            controllerToViewQueue.put(message);
            Thread.sleep(time);
        }
    }

    public void run() {
        try {
            startTimer();
        }
        catch (Exception e) {

        }
    }
}
