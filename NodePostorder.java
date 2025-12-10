package BinaryTreeExercises;

public class NodePostorder {
    int value;
    NodePostorder left;
    NodePostorder right;

    public NodePostorder(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void postorderTraversal() {
        if (left != null) left.postorderTraversal();
        if (right != null) right.postorderTraversal();
        System.out.print(value + " ");
    }
}

