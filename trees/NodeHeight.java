package BinaryTreeExercises;

public class NodeHeight {
    int value;
    NodeHeight left;
    NodeHeight right;

    public NodeHeight(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int height() {
        int leftHeight = (left == null) ? 0 : left.height() + 1;
        int rightHeight = (right == null) ? 0 : right.height() + 1;
        return Math.max(leftHeight, rightHeight);
    }
}
