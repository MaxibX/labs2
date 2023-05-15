package commands;

public class Mul extends Strategy {
    public Mul(Object[] args) {
        super(args);
    }

    @Override
    public void exec() {
        Float first = model.popStack();
        Float second = model.popStack();
        first *= second;
        model.pushStack(first);
    }
}
