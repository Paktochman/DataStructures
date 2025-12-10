package Stacks;

public class DynamicArrayStack {
    private int[] arr;
    private int top;
    private int capacity;

    public DynamicArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top + 1 == capacity) {
            resize(capacity * 2);
        }
        arr[++top] = x;
        printState("push(" + x + ")");
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        int val = arr[top--];
        if (top + 1 > 0 && top + 1 <= capacity / 4) {
            resize(capacity / 2);
        }
        printState("pop()");
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        System.arraycopy(arr, 0, newArr, 0, top + 1);
        arr = newArr;
        capacity = newCapacity;
    }

    private void printState(String operation) {
        System.out.print(operation + " -> Array: [");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + (i == top ? "" : ", "));
        }
        System.out.println("], Capacity: " + capacity);
    }

    public static void main(String[] args) {
        DynamicArrayStack stack = new DynamicArrayStack(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        stack.push(9);
    }
}
