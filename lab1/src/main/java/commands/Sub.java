package commands;

import exceptions.NoStackElement;
import exceptions.TooManyArgs;

public class Sub extends Strategy {
    public Sub(Object[] args) {
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
        second -= first;
        model.pushStack(second);
    }
}
