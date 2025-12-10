package Stacks;

import java.util.*;

public class FirstNonRepeatingCharacter {
    public static void firstNonRepeating(String stream) {
        Queue<Character> queue = new LinkedList<>();
        int[] freq = new int[256];

        for (char c : stream.toCharArray()) {
            queue.add(c);
            freq[c]++;
            while (!queue.isEmpty() && freq[queue.peek()] > 1) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                System.out.print(queue.peek() + " ");
            } else {
                System.out.print("-1 ");
            }
        }
    }

    public static void main(String[] args) {
        String stream = "aabcdbecff";
        firstNonRepeating(stream);
    }
}
