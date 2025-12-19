package linkedlists;

public class CycleDetection {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public boolean hasCycle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public Node detectCycleStart(Node head) {
        Node slow = head, fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next; fast = fast.next.next;
            if (slow == fast) { hasCycle = true; break; }
        }
        if (!hasCycle) return null;
        slow = head;
        while (slow != fast) { slow = slow.next; fast = fast.next; }
        return slow;
    }
}
