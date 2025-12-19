package linkedlists;

public class MergeSortedLinkedLists {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node curr = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) { curr.next = a; a = a.next; }
            else { curr.next = b; b = b.next; }
            curr = curr.next;
        }
        curr.next = (a != null) ? a : b;
        return dummy.next;
    }
}
