package stacks;

public class SimpleStack {
    private int[] stack;
    private int top;

    public SimpleStack() {
        stack = new int[10];
        top = -1;
    }

    public void push(int value) {
        stack[++top] = value;
    }

    public int pop() {
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
