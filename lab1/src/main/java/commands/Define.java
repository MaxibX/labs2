package commands;

import exceptions.TooManyArgs;

import java.util.Objects;

public class Define extends Strategy {
    private String param;
    private Float value;
    public Define(Object[] args) {
        super(args);
        if (args.length != 3) {
            throw new TooManyArgs();
        }
        if ((args[1] instanceof String) && (args[2] instanceof String)) {
            param = (String) args[1];
            try {
                value = Float.parseFloat((String) args[2]);
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
