package BinaryTreeExercises;

public class NodeFindMinMax {
    int value;
    NodeFindMinMax left;
    NodeFindMinMax right;

    public NodeFindMinMax(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int findMin() {
        NodeFindMinMax curr = this;
        while (curr.left != null) curr = curr.left;
        return curr.value;
    }

    public int findMax() {
        NodeFindMinMax curr = this;
        while (curr.right != null) curr = curr.right;
        return curr.value;
    }
}
