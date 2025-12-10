package Stacks;

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
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // Main method for testing
    public static void main(String[] args) {
        SimpleStack stack = new SimpleStack();
        
        System.out.println("Pushing 10, 20, 30 onto the stack...");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popping values from stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
