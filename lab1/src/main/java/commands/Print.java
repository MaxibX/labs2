package commands;

public class Print extends Strategy {

    public Print(Object[] args) {
        super(args);
    }

    @Override
    public void exec() {
        System.out.println(model.peekStack());
    }
}
