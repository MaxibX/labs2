package ru.nsu.ccfit.nadezhkin.lab2;

import java.util.concurrent.BlockingQueue;
public class Controller implements Runnable {
    private Model model;
    private BlockingQueue<Message> controllerToViewQueue;
    private BlockingQueue<Message> viewToControllerQueue;
    public void setModel(Model m) {
        model = m;
    }
    public void setControllerToViewQueue(BlockingQueue<Message> c) {
        this.controllerToViewQueue = c;
    }
    public void setViewToControllerQueue(BlockingQueue<Message> v) {
        this.viewToControllerQueue = v;
    }
    public void run() {
        try {
            loop();
        }
        catch(Exception e) {}
    }
    private void loop() throws InterruptedException {
        Message message;
        message = new Message(Message.TYPE.CHANGE_NEXT, model.get_next());
        controllerToViewQueue.put(message);
        while (true) {
            message = viewToControllerQueue.take();
            if (message == null) {
                continue;
            }
            if (model.game_over) {
                if (message.getType() == Message.TYPE.RESTART) {
                    model.restart();
                    message = new Message(Message.TYPE.SCORE_UPDATE, model.get_score());
                    controllerToViewQueue.put(message);
                }
                else {
                    continue;
                }
            }
            switch (message.getType()) {
                case MOVE_LEFT:
                    if (model.is_left_enable()) {
                        model.move_left();
                        message = new Message(Message.TYPE.REDRAW, model.get_data());
                        controllerToViewQueue.put(message);
                    }
                    break;
                case MOVE_RIGHT:
                    if (model.is_right_enable()) {
                        model.move_right();
                        message = new Message(Message.TYPE.REDRAW, model.get_data());
                        controllerToViewQueue.put(message);
                    }
                    break;
                case ROTATE_LEFT:
                    if (!model.is_left_rotate_enable()) break;
                    model.rotate_left();
                    message = new Message(Message.TYPE.REDRAW, model.get_data());
                    controllerToViewQueue.put(message);
                    break;
                case ROTATE_RIGHT:
                    if (!model.is_right_rotate_enable()) break;
                    model.rotate_right();
                    message = new Message(Message.TYPE.REDRAW, model.get_data());
                    controllerToViewQueue.put(message);
                    break;
                case FASTER:
                    if (model.is_fall_enable()) {
                        model.move_down();
                    }
                    else if (model.is_end() && !model.game_over) {
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
                    break;
                default:
                    break;
            }
        }
    }
}
