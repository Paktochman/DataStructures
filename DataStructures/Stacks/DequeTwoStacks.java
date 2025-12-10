package Stacks;

import java.util.Stack;

public class DequeTwoStacks {
    private Stack<Integer> frontStack;
    private Stack<Integer> backStack;

    public DequeTwoStacks() {
        frontStack = new Stack<>();
        backStack = new Stack<>();
    }

    public void push_front(int x) {
        frontStack.push(x);
        printState("push_front(" + x + ")");
    }

    public void push_back(int x) {
        backStack.push(x);
        printState("push_back(" + x + ")");
    }

    public int pop_front() {
        if (frontStack.isEmpty()) rebalance(backStack, frontStack);
        int val = frontStack.pop();
        printState("pop_front()");
        return val;
    }

    public int pop_back() {
        if (backStack.isEmpty()) rebalance(frontStack, backStack);
        int val = backStack.pop();
        printState("pop_back()");
        return val;
    }

    private void rebalance(Stack<Integer> source, Stack<Integer> target) {
        int half = (source.size() + 1) / 2;
        Stack<Integer> temp = new Stack<>();
        for (int i = 0; i < half; i++) temp.push(source.pop());
        while (!temp.isEmpty()) target.push(temp.pop());
    }

    private void printState(String operation) {
        System.out.println(operation + " -> frontStack: " + frontStack + ", backStack: " + backStack);
    }

    public static void main(String[] args) {
        DequeTwoStacks dq = new DequeTwoStacks();
        dq.push_front(4);
        dq.push_back(8);
        dq.push_front(1);
        dq.pop_back();
        dq.pop_front();
        dq.push_back(11);
    }
}
