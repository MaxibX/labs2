package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.model.Model;

public abstract class Strategy {
    protected Model model;
    protected int ZERO = 0;
    protected int COUNT_ONE = 1;
    protected int COUNT_TWO = 2;
    protected int COUNT_THREE = 3;
    protected int ZERO_ELEM = 0;
    protected int FIRST_ELEM = 1;
    protected int SECOND_ELEM = 2;
    public Strategy(Object[] args) {
        if (args.length != ZERO && (args[ZERO_ELEM] instanceof Model)) {
            model = (Model) args[ZERO_ELEM];
        }
    }
    public abstract void exec();
}
