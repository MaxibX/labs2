package commands;

import exceptions.TooManyArgs;

import java.util.Objects;

public class Define extends Strategy {
    private String param;
    private Float value;
    public Define(Object[] args) {
        super(args);
        if (args.length != COUNT_THREE) {
            throw new TooManyArgs();
        }
        if ((args[FIRST_ELEM] instanceof String) && (args[SECOND_ELEM] instanceof String)) {
            param = (String) args[FIRST_ELEM];
            try {
                value = Float.parseFloat((String) args[SECOND_ELEM]);
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
    }

    @Override
    public void exec() {
        model.defineParam(param, value);
    }
}
