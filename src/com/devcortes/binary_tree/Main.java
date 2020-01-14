package com.devcortes.binary_tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(56);
        binaryTree.insert(12);
        binaryTree.insert(98);
        binaryTree.insert(100);
        binaryTree.insert(32);
        binaryTree.insert(44);
        binaryTree.insert(4565);

        int a = binaryTree.find(44).value;
    }
}

class BinaryTree {
    Node root;

    public void insert(int key) {
        Node node = new Node(key);
        if (root == null) {
            root = node;
        } else {
            Node current = root;
            Node prev = null;
            while (true) {
                prev = current;
                if (key < prev.value) {
                    current = current.left;
                    if (current == null) {
                        prev.left = node;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        prev.right = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key) {
        Node current = root;
        while (current.value != key) {
            if (current.value < key) {
                current = current.right;
            } else if (current.value > key) {
                current = current.left;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void add(int value) {

        if (root == null) {
            root = new Node(value);
        } else {
            addRecursive(root, value);
        }
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            return addRecursive(current.left, value);
        } else if (value > current.value) {
            return addRecursive(current.right, value);
        } else {
            return current;
        }
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}