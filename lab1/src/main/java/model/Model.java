package model;

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
        return stack.pop();
    }
    public void defineParam(String str, Float number) {
        param.put(str, number);
    }
    public Float defineGet(String str) {
        return param.get(str);
    }
    public Float peekStack() {
        return stack.peek();
    }
}
