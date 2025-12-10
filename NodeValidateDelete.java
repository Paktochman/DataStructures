package BinaryTreeExercises;

public class NodeValidateDelete {
    int value;
    NodeValidateDelete left;
    NodeValidateDelete right;

    public NodeValidateDelete(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean isValidBST() {
        return isValidBSTHelper(this, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValidBSTHelper(NodeValidateDelete node, int min, int max) {
        if (node == null) return true;
        if (node.value <= min || node.value >= max) return false;
        return isValidBSTHelper(node.left, min, node.value)
            && isValidBSTHelper(node.right, node.value, max);
    }

    public NodeValidateDelete delete(int val) {
        if (val < this.value) {
            if (left != null) left = left.delete(val);
        } else if (val > this.value) {
            if (right != null) right = right.delete(val);
        } else {
            if (left == null && right == null) return null;
            if (left == null) return right;
            if (right == null) return left;

            int successor = right.findMin();
            this.value = successor;
            right = right.delete(successor);
        }
        return this;
    }

    private int findMin() {
        NodeValidateDelete curr = this;
        while (curr.left != null) curr = curr.left;
        return curr.value;
    }
}
