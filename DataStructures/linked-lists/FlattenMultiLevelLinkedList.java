package linkedlists;

class MultiLevelNode {
    int val;
    MultiLevelNode next;
    MultiLevelNode child;
    MultiLevelNode(int val) { this.val = val; }
}

public class FlattenMultiLevelLinkedList {
    public static MultiLevelNode flatten(MultiLevelNode head) {
        if (head == null) return null;
        MultiLevelNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                MultiLevelNode next = curr.next;
                MultiLevelNode childHead = flatten(curr.child);
                curr.next = childHead;
                curr.child = null;

                // Move to end of child list
                MultiLevelNode temp = childHead;
                while (temp.next != null) temp = temp.next;
                temp.next = next;
            }
            curr = curr.next;
        }
        return head;
    }
}
