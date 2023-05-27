package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoStackElement;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.TooManyArgs;

public class Pop extends Strategy {
    public Pop(Object[] args) {
        super(args);
        if (args.length != COUNT_ONE) {
            throw new TooManyArgs();
        }
    }

    @Override
    public void exec() {
        try {
            model.popStack();
        }
        catch (NoStackElement e) {
            throw new NoStackElement();
        }
    }
}
