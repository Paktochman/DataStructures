package linkedlists;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    // addFirst: O(1)
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    // addLast: O(n)
    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = node;
    }

    // removeFirst: O(1)
    public void removeFirst() {
        if (head != null) head = head.next;
    }

    // removeLast: O(n)
    public void removeLast() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node curr = head;
        while (curr.next.next != null) curr = curr.next;
        curr.next = null;
    }

    // get(index): O(n)
    public Node get(int index) {
        Node curr = head;
        for (int i = 0; i < index && curr != null; i++) curr = curr.next;
        return curr;
    }
}
