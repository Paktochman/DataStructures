package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingTwoDeques {
    private Deque<Integer> deque1; // active
    private Deque<Integer> deque2; // auxiliary

    public StackUsingTwoDeques() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void push(int x) {
        deque1.addLast(x); // always push to active deque
        printState("push(" + x + ")");
    }

    public int pop() {
        if (deque1.isEmpty()) throw new RuntimeException("Stack is empty");
        while (deque1.size() > 1) deque2.addLast(deque1.removeFirst());
        int val = deque1.removeFirst();
        // Swap roles
        Deque<Integer> temp = deque1;
        deque1 = deque2;
        deque2 = temp;
        printState("pop()");
        return val;
    }

    private void printState(String operation) {
        System.out.println(operation + " -> activeDeque: " + deque1 + ", auxiliaryDeque: " + deque2);
    }

    public static void main(String[] args) {
        StackUsingTwoDeques stack = new StackUsingTwoDeques();
        stack.push(5);
        stack.push(10);
        stack.push(3);
        stack.pop();
        stack.push(7);
    }
}
