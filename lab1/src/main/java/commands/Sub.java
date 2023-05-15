package commands;

public class Sub extends Strategy {
    public Sub(Object[] args) {
        super(args);
    }

    @Override
    public void exec() {
        Float first = model.popStack();
        Float second = model.popStack();
        first -= second;
        model.pushStack(first);
    }
}
