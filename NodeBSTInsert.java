package BinaryTreeExercises;

public class NodeBSTInsert {
    int value;
    NodeBSTInsert left;
    NodeBSTInsert right;

    public NodeBSTInsert(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public void insert(int val) {
        if (val < this.value) {
            if (left == null) left = new NodeBSTInsert(val);
            else left.insert(val);
        } else {
            if (right == null) right = new NodeBSTInsert(val);
            else right.insert(val);
        }
    }
}
