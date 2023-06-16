package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoStackElement;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.TooManyArgs;

public class Print extends Strategy {

    public Print(Object[] args) {
        super(args);
        if (args.length != COUNT_ONE) {
            throw new TooManyArgs();
        }
    }

    @Override
    public void exec() {
        Float tmp;
        try {
            tmp = model.peekStack();
        }
        catch (NoStackElement e) {
            throw new NoStackElement();
        }
        if (tmp % Math.round(tmp) != ZERO && tmp != ZERO) {
            System.out.println(tmp);
        }
        else {
            System.out.println(Math.round(tmp));
        }
    }
}
