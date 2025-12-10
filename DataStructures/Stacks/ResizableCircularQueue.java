package Stacks;

public class ResizableCircularQueue {
    private int[] arr;
    private int front, rear, size, capacity;

    public ResizableCircularQueue(int initialCapacity) {
        capacity = initialCapacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int x) {
        if (size == capacity) {
            resize(capacity * 2);
        }
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

    public boolean isEmpty() { return size == 0; }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % capacity];
        }
        arr = newArr;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
    }

    private void printState(String operation) {
        System.out.print(operation + " -> Queue: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + (i == size - 1 ? "" : ", "));
        }
        System.out.println("], Front: " + front + ", Rear: " + rear + ", Capacity: " + capacity);
    }

    public static void main(String[] args) {
        ResizableCircularQueue q = new ResizableCircularQueue(3);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40); // triggers resize
    }
}
