package linkedlists;

public class RemoveKthLastNode {
    public static ListNode removeKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy, second = dummy;

        // Move first k+1 steps ahead
        for (int i = 0; i <= k; i++) first = first.next;

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
