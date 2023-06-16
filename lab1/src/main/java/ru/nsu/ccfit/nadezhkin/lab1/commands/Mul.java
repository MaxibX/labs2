package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoStackElement;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.TooManyArgs;

public class Mul extends Strategy {
    public Mul(Object[] args) {
        super(args);
        if (args.length != COUNT_ONE) {
            throw new TooManyArgs();
        }
    }

    @Override
    public void exec() {
        Float first;
        try {
            first = model.popStack();
        }
        catch (NoStackElement e) {
            throw new NoStackElement();
        }
        Float second;
        try {
            second = model.popStack();
        }
        catch (NoStackElement e) {
            model.pushStack(first);
            throw new NoStackElement();
        }
        second *= first;
        model.pushStack(second);
    }
}
