package Stacks;

public class DequeCircularArray {
    private int[] arr;
    private int front, rear, size, capacity;

    public DequeCircularArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == capacity; }

    public void push_front(int x) {
        if (isFull()) throw new RuntimeException("Deque Full");
        if (isEmpty()) front = rear = 0;
        else front = (front - 1 + capacity) % capacity;
        arr[front] = x;
        size++;
        printState("push_front(" + x + ")");
    }

    public void push_back(int x) {
        if (isFull()) throw new RuntimeException("Deque Full");
        if (isEmpty()) front = rear = 0;
        else rear = (rear + 1) % capacity;
        arr[rear] = x;
        size++;
        printState("push_back(" + x + ")");
    }

    public int pop_front() {
        if (isEmpty()) throw new RuntimeException("Deque Empty");
        int val = arr[front];
        if (front == rear) front = rear = -1;
        else front = (front + 1) % capacity;
        size--;
        printState("pop_front()");
        return val;
    }

    public int pop_back() {
        if (isEmpty()) throw new RuntimeException("Deque Empty");
        int val = arr[rear];
        if (front == rear) front = rear = -1;
        else rear = (rear - 1 + capacity) % capacity;
        size--;
        printState("pop_back()");
        return val;
    }

    private void printState(String operation) {
        System.out.print(operation + " -> Deque: [");
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + (i == size - 1 ? "" : ", "));
            }
        }
        System.out.println("], Front: " + front + ", Rear: " + rear);
    }

    public static void main(String[] args) {
        DequeCircularArray dq = new DequeCircularArray(6);
        dq.push_back(1);
        dq.push_back(2);
        dq.push_front(9);
        dq.push_front(7);
        dq.pop_back();
        dq.push_back(5);
        dq.pop_front();
    }
}
