package Stacks;

import java.util.*;

public class RotateDeque {
    public static void rotate(Deque<Integer> deque, int k) {
        for (int i = 0; i < k; i++) {
            int val = deque.removeLast();
            deque.addFirst(val);
            System.out.println("Rotation " + (i+1) + ": " + deque);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>(Arrays.asList(10, 20, 30, 40, 50));
        rotate(deque, 4);
    }
}
