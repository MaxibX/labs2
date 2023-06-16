package ru.nsu.ccfit.nadezhkin.lab1.commands;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.TooManyArgs;

public class Define extends Strategy {
    private String param;
    private String value;
    public Define(Object[] args) {
        super(args);
        if (args.length != COUNT_THREE) {
            throw new TooManyArgs();
        }
        if ((args[FIRST_ELEM] instanceof String) && (args[SECOND_ELEM] instanceof String)) {
            param = (String) args[FIRST_ELEM];
            value = (String) args[SECOND_ELEM];
            /*try {
                value = Float.parseFloat((String) args[SECOND_ELEM]);
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException();
            }*/
        }
    }

    @Override
    public void exec() {
        model.defineParam(param, value);
    }
}
