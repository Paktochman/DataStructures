package Stacks;

import java.util.Stack;

public class QueueUsingTwoStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void enqueue(int x) {
        s1.push(x);
        System.out.println("Enqueue " + x + " -> s1: " + s1 + ", s2: " + s2);
    }

    public int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
        int val = s2.pop();
        System.out.println("Dequeue -> s1: " + s1 + ", s2: " + s2);
        return val;
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();
        q.enqueue(1);
        q.enqueue(2);
        q.dequeue();
        q.enqueue(3);
        q.dequeue();
        q.enqueue(4);
        q.dequeue();
    }
}
