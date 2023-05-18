package commands;

import exceptions.DivByZero;
import exceptions.NoStackElement;
import exceptions.TooManyArgs;

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
