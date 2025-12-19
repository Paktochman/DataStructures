package linkedlists;


public class SinglyLinkedListTail {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    // addFirst: O(1)
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) tail = node;
    }

    // addLast: O(1)
    public void addLast(int data) {
        Node node = new Node(data);
        if (tail == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    // removeLast: O(n)
    public void removeLast() {
        if (head == null) return;
        if (head == tail) { head = tail = null; return; }
        Node curr = head;
        while (curr.next != tail) curr = curr.next;
        curr.next = null;
        tail = curr;
    }
}
