package BinaryTreeExercises;

public class NodePreorder {
    int value;
    NodePreorder left;
    NodePreorder right;

    public NodePreorder(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void preorderTraversal() {
        System.out.print(value + " ");
        if (left != null) left.preorderTraversal();
        if (right != null) right.preorderTraversal();
    }
}
