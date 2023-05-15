package commands;

public class Pop extends Strategy {
    public Pop(Object[] args) {
        super(args);

    }
    @Override
    public void exec() {
        model.popStack();
    }
}
