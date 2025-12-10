package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {
    private Deque<Integer> deque;

    public StackUsingDeque() {
        deque = new ArrayDeque<>();
    }

    // Push element to stack
    public void push(int x) {
        deque.addLast(x); // use one end as stack top
        printState("push(" + x + ")");
    }

    // Pop element from stack
    public int pop() {
        int val = deque.removeLast(); // remove from same end
        printState("pop()");
        return val;
    }

    // Peek top element
    public int top() {
        return deque.peekLast();
    }

    private void printState(String operation) {
        System.out.println(operation + " -> Stack (deque): " + deque);
    }

    public static void main(String[] args) {
        StackUsingDeque stack = new StackUsingDeque();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.pop();
        stack.push(6);
        stack.pop();
    }
}
