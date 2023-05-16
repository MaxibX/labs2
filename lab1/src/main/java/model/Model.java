package model;

import exceptions.NoMapKey;
import exceptions.NoStackElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Model {
    private Stack<Float> stack;
    private Map<String, Float> param;
    public Model() {
        stack = new Stack<Float>();
        param = new HashMap<String, Float>();
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
    public void defineParam(String str, Float number) {
        param.put(str, number);
    }
    public Float defineGet(String str) {
        if (param.containsKey(str)) {
            return param.get(str);
        }
        else {
            throw new NoMapKey();
        }
    }
    public Float peekStack() {
        if (stack.empty()) {
            throw new NoStackElement();
        }
        return stack.peek();
    }
}
