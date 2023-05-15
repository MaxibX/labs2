package presenter;

import commands.Push;
import factory.Factory;
import model.Model;
import view.View;

public class Presenter implements IViewListener {
    private Model model;
    private View view;
    private Factory factory;
    public Presenter() {
        model = new Model();
        view = new View(this);
        factory = new Factory(model);
    }
    public void run() {
        while (true) {
            view.ask_str();
        }
    }
    @Override
    public void get_str(String str) {
        factory.createCommand(str).exec();
    }
}
