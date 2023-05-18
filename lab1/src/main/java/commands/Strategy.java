package commands;

import model.Model;

public abstract class Strategy {
    protected Model model;
    protected static int ZERO = 0;
    protected static int COUNT_ONE = 1;
    protected static int COUNT_TWO = 2;
    protected static int COUNT_THREE = 3;
    protected static int ZERO_ELEM = 0;
    protected static int FIRST_ELEM = 1;
    protected static int SECOND_ELEM = 2;
    public Strategy(Object[] args) {
        if (args.length != ZERO && (args[ZERO_ELEM] instanceof Model)) {
            model = (Model) args[ZERO_ELEM];
        }
    }
    public abstract void exec();
}
