package commands;

import exceptions.NoMapKey;
import exceptions.TooManyArgs;

public class Push extends Strategy {
    private String param = null;
    private Float paramFloat;
    public Push(Object[] args) {
        super(args);
        if (args.length != COUNT_TWO) {
            throw new TooManyArgs();
        }
        if (args[1] instanceof String) {
            try {
                paramFloat = Float.parseFloat((String) args[FIRST_ELEM]);
            }
            catch (NumberFormatException e) {
                param = (String) args[FIRST_ELEM];
            }
        }
    }

    @Override
    public void exec() {
        if (param != null) {
            Float tmp;
            try {
                tmp = model.defineGet(param);
            }
            catch (NoMapKey e) {
                throw new NoMapKey();
            }
            model.pushStack(tmp);
        }
        else {
            model.pushStack(paramFloat);
        }
    }
}
