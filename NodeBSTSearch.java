package BinaryTreeExercises;

public class NodeBSTSearch {
    int value;
    NodeBSTSearch left;
    NodeBSTSearch right;

    public NodeBSTSearch(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean search(int val) {
        if (val == value) return true;
        if (val < value) return (left != null) && left.search(val);
        else return (right != null) && right.search(val);
    }
}
