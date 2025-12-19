package linkedlists;

public class ReverseLinkedList {
    static class Node {
        int data; Node next;
        Node(int data) { this.data = data; }
    }

    public Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
