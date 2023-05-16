package commands;

import exceptions.NoStackElement;
import exceptions.TooManyArgs;

public class Pop extends Strategy {
    public Pop(Object[] args) {
        super(args);
        if (args.length != 1) {
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
