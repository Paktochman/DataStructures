package Stacks;

public class CircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (isFull()) throw new RuntimeException("Queue Full");
        rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
        printState("enqueue(" + x + ")");
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        printState("dequeue()");
        return val;
    }

    public int getFront() {
        if (isEmpty()) throw new RuntimeException("Queue Empty");
        return arr[front];
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    private void printState(String operation) {
        System.out.print(operation + " -> Queue: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % capacity] + (i == size - 1 ? "" : ", "));
        }
        System.out.println("], Front: " + front + ", Rear: " + rear);
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(3);
        q.enqueue(7);
        q.enqueue(9);
        q.dequeue();
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(10);
    }
}
