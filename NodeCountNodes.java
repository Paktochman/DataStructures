package BinaryTreeExercises;

public class NodeCountNodes {
    int value;
    NodeCountNodes left;
    NodeCountNodes right;

    public NodeCountNodes(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int countNodes() {
        int leftCount = (left == null) ? 0 : left.countNodes();
        int rightCount = (right == null) ? 0 : right.countNodes();
        return 1 + leftCount + rightCount;
    }
}
