package linkedlists;

public class SearchDeleteLinkedList {
    static class Node {
        int data; Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    public Node find(int data) {
        Node curr = head;
        while (curr != null) { if (curr.data == data) return curr; curr = curr.next; }
        return null;
    }

    public void delete(int data) {
        if (head == null) return;
        if (head.data == data) { head = head.next; return; }
        Node curr = head;
        while (curr.next != null && curr.next.data != data) curr = curr.next;
        if (curr.next != null) curr.next = curr.next.next;
    }
}
