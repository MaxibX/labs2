package commands;

import exceptions.DivByZero;
import exceptions.NoStackElement;
import exceptions.TooManyArgs;

public class Div extends Strategy {

    public Div(Object[] args) {
        super(args);
        if (args.length != 1) {
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
        if (first != 0) {
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
