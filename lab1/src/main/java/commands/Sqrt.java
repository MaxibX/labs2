package commands;

import exceptions.NoStackElement;
import exceptions.SqrtNegativeNumber;
import exceptions.TooManyArgs;

public class Sqrt extends Strategy {

    public Sqrt(Object[] args) {
        super(args);
        if (args.length != 1) {
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
        if (first >= 0)
            first = (float) Math.sqrt(first);
        else {
            throw new SqrtNegativeNumber();
        }
        model.pushStack(first);
    }
}
