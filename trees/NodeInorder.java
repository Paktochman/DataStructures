package BinaryTreeExercises;

public class NodeInorder {
    int value;
    NodeInorder left;
    NodeInorder right;

    public NodeInorder(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void inorderTraversal() {
        if (left != null) left.inorderTraversal();
        System.out.print(value + " ");
        if (right != null) right.inorderTraversal();
    }
}
