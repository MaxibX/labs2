package commands;

import model.Model;

public abstract class Strategy {
    protected Model model;
    public Strategy(Object[] args) {
        if (args.length != 0 && (args[0] instanceof Model)) {
            model = (Model) args[0];
        }
    }
    public abstract void exec();
}
