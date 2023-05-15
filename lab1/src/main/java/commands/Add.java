package commands;

public class Add extends Strategy {
    private String param;
    public Add(Object[] args) {
        super(args);
    }

    @Override
    public void exec() {
        Float first = model.popStack();
        Float second = model.popStack();
        first += second;
        model.pushStack(first);
    }
}
