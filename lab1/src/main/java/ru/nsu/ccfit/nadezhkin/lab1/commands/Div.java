package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.DivByZero;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoStackElement;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.TooManyArgs;

public class Div extends Strategy {

    public Div(Object[] args) {
        super(args);
        if (args.length != COUNT_ONE) {
            throw new TooManyArgs();
        }
    }

    @Override
    public void exec() {
        Float first;
        try {
            first = model.peekStack();
        }
        catch (NoStackElement e) {
            throw new NoStackElement();
        }
        if (first != ZERO) {
            first = model.popStack();
            Float second;
            try {
                second = model.popStack();
            }
            catch (NoStackElement e) {
                throw new NoStackElement();
            }
            second /= first;
            model.pushStack(second);
        }
        else {
            throw new DivByZero();
        }
    }
}
