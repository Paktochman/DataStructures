package Stacks;

import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {
    public static int[] nextGreater(int[] arr) {
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
            System.out.println("i=" + i + ", stack indices=" + stack);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {6, 8, 0, 1, 3};
        int[] res = nextGreater(arr);
        System.out.println("Next Greater Elements: " + Arrays.toString(res));
    }
}
