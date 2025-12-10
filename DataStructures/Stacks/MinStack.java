package Stacks;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
        printState("push(" + x + ")");
    }

    public void pop() {
        if (mainStack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        mainStack.pop();
        printState("pop()");
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    private void printState(String operation) {
        System.out.println(operation);
        System.out.println("Main Stack: " + mainStack);
        System.out.println("Min Stack: " + minStack);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.pop();
        stack.push(1);
        System.out.println("Minimum: " + stack.getMin());
    }
}
