package binarytree;

public class Node {
    private int value;
    private Node leftNode;
    private Node rightNode;

    public Node(int value) {
        this.value = value;
        leftNode = null;
        rightNode = null;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return leftNode;
    }

    public void setLeft(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRight() {
        return rightNode;
    }

    public void setRight(Node rightNode) {
        this.rightNode = rightNode;
    }
}
