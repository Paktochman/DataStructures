package BinaryTreeExercises;

import java.util.LinkedList;
import java.util.Queue;

public class NodeLevelOrder {
    int value;
    NodeLevelOrder left;
    NodeLevelOrder right;

    public NodeLevelOrder(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void levelOrderTraversal() {
        Queue<NodeLevelOrder> q = new LinkedList<>();
        q.add(this);
        while (!q.isEmpty()) {
            NodeLevelOrder curr = q.poll();
            System.out.print(curr.value + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }
}
