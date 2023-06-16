package ru.nsu.ccfit.nadezhkin.lab1.model;

import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoMapKey;
import ru.nsu.ccfit.nadezhkin.lab1.exceptions.NoStackElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Model {
    private Stack<Float> stack;
    private Map<String, String> param;
    public Model() {
        stack = new Stack<Float>();
        param = new HashMap<String, String>();
    }
    public void pushStack(Float number) {
        stack.push(number);
    }
    public Float popStack() {
        if (stack.empty()) {
            throw new NoStackElement();
        }
        return stack.pop();
    }
    public void defineParam(String str, String number) {
        param.put(str, number);
    }
    public Float defineGet(String str) {
        Float number = null;
        while (number == null) {
            if (param.containsKey(str)) {
                try {
                    number = Float.parseFloat(param.get(str));
                }
                catch (NumberFormatException e) {
                    str = param.get(str);
                }
            }
            else {
                throw new NoMapKey();
            }
        }
        return number;
    }
    public Float peekStack() {
        if (stack.empty()) {
            throw new NoStackElement();
        }
        return stack.peek();
    }
}
