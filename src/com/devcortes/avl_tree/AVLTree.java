package com.devcortes.avl_tree;

public class AVLTree {

    private Node root;

    private class Node {

        private int value;
        private int height = 1;
        private Node parent;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balance (Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private int defineHeight(Node current) {
        return Math.max(height(current.left), height(current.right)) + 1;
    }

    public void add (int value) {
        root = add(root, value);
    }

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (current.value > value) {
            current.left = add(current.left, value);
        } else if (current.value < value) {
            current.right = add(current.right, value);
        } else {
            return current;
        }

        current.height = defineHeight(current);

        int balance = balance(current);

        if (balance > 1 && current.left.value > value) {
            return rightRotate(current);
        }

        if (balance < -1 && current.right.value < value) {
            return leftRotate(current);
        }

        if (balance > 1 && current.left.value < value) {
            current.left = leftRotate(current.left);
            return rightRotate(current);

        }

        if (balance < -1 && current.right.value > value) {
            current.right = rightRotate(current.right);
            return leftRotate(current);
        }

        return current;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = defineHeight(y);
        x.height = defineHeight(x);

        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        y.height = defineHeight(y);
        x.height = defineHeight(x);

        return y;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}
