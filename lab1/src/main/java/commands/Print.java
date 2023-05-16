package commands;

import exceptions.NoStackElement;
import exceptions.TooManyArgs;

public class Print extends Strategy {

    public Print(Object[] args) {
        super(args);
        if (args.length != 1) {
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
        if (tmp % Math.round(tmp) != 0 && tmp != 0) {
            System.out.println(tmp);
        }
        else {
            System.out.println(Math.round(tmp));
        }
    }
}