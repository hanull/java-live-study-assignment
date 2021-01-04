package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    Node root;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            Node curNode = root;
            Node parent;

            while (true) {
                parent = curNode;
                if (value < curNode.getValue()) {
                    curNode = curNode.getLeft();
                    if (curNode == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    curNode = curNode.getRight();
                    if (curNode == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }

    }

    public Node getRootNode() {
        return root;
    }

    public boolean contains(Node curNode, int value) {
        if (curNode == null) {
            return false;
        } else if (value == curNode.getValue()) {
            return true;
        }
        return curNode.getValue() > value ? contains(curNode.getLeft(), value) : contains(curNode.getRight(), value);
    }

    public void bfs() {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curNode = q.poll();

            System.out.print(curNode.getValue() + " ");

            if (curNode.getLeft() != null) {
                q.add(curNode.getLeft());
            }
            if (curNode.getRight() != null) {
                q.add(curNode.getRight());
            }
        }
    }

    public void dfs(Node node) {
        if (node == null) return;

        dfs(node.getLeft());
        System.out.print(node.getValue() + " ");
        dfs(node.getRight());
    }

    public void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.getLeft());
        System.out.print(node.getValue() + " ");
        inOrderTraversal(node.getRight());
    }

    public void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        preOrderTraversal(node.getLeft());
        preOrderTraversal(node.getRight());
    }

    public void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.getLeft());
        postOrderTraversal(node.getRight());
        System.out.print(node.getValue() + " ");
    }

}
