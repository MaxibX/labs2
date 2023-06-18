package ru.nsu.ccfit.nadezhkin.lab2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    private final int buf_size = 1024;
    private View view;
    private Model model;
    private Controller controller;
    private TimeController timeController;
    private Thread controllerThread;
    private Thread viewThread;
    private Thread timeControllerThread;

    private BlockingQueue<Message> controllerToViewQueue = new ArrayBlockingQueue<>(buf_size);
    private BlockingQueue<Message> viewToControllerQueue = new ArrayBlockingQueue<>(buf_size);

    public Main() {
        model = new Model();
        view = new View();
        controller = new Controller();
        timeController = new TimeController();

        controller.setModel(model);
        controller.setControllerToViewQueue(controllerToViewQueue);
        controller.setViewToControllerQueue(viewToControllerQueue);

        timeController.setModel(model);
        timeController.setControllerToViewQueue(controllerToViewQueue);

        view.setControllerToViewQueue(controllerToViewQueue);
        view.setViewToControllerQueue(viewToControllerQueue);

        controllerThread = new Thread(controller);
        viewThread = new Thread(view);
        timeControllerThread = new Thread(timeController);

        controllerThread.start();
        viewThread.start();
        timeControllerThread.start();
    }

    public static void main(String[] args) {
        Main tetris = new Main();
    }
}
