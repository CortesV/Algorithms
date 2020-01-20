package com.devcortes.avl_tree;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    class Node {
        private Node parent;
        private Node left;
        private Node right;
        private int height = 1;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.getHeight();
    }

    private int balance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.getLeft()) - height(root.getRight());
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node root, int value) {
        // Add element
        if (root == null) {
            return new Node(value);
        }

        if (root.getValue() < value) {
            root.setRight(add(root.getRight(), value));
        } else if (root.getValue() > value) {
            root.setLeft(add(root.getLeft(), value));
        }

        // Update height
        root.setHeight(Math.max(height(root.getLeft()), height(root.getRight())) + 1);

        int balance = balance(root);

        // If tree is not balanced

        // Left Left Case
        if (balance > 1 && value < root.getLeft().getValue()) {
            return rightRotate(root);
        }

        // Right Right Case
        if (balance > -1 && value > root.getLeft().getValue()) {
            return leftRotate(root);
        }

        // Left Right Case
        if (balance > 1 && value > root.getLeft().getValue()) {
            root.left = leftRotate(root.getLeft());
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && value < root.getRight().getValue()) {
            root.right = rightRotate(root.getRight());
            return leftRotate(root);
        }

        return root;
    }

    private Node rightRotate(Node nodeY) {
        Node nodeX = nodeY.left;
        Node temp = nodeX.right;

        // Perform rotation
        nodeX.right = nodeY;
        nodeY.left = temp;

        // Update heights
        nodeY.height = Math.max(height(nodeY.left), height(nodeY.right)) + 1;
        nodeX.height = Math.max(height(nodeX.left), height(nodeX.right)) + 1;

        // Return new root
        return nodeX;
    }

    private Node leftRotate(Node nodeX) {
        Node nodeY = nodeX.right;
        Node temp = nodeY.left;

        // Perform rotation
        nodeY.left = nodeX;
        nodeX.right = temp;

        //  Update heights
        nodeX.height = Math.max(height(nodeX.left), height(nodeX.right)) + 1;
        nodeY.height = Math.max(height(nodeY.left), height(nodeY.right)) + 1;

        // Return new root
        return nodeY;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        /* loop down to find the leftmost leaf */
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node deleteNode(int value) {
        return deleteNode(root, value);
    }

    private Node deleteNode(Node root, int value) {
        // STEP 1: PERFORM STANDARD BST DELETE

        if (root == null)
            return root;

        // If the value to be deleted is smaller than the root's value,
        // then it lies in left subtree
        if (value < root.value)
            root.left = deleteNode(root.left, value);

            // If the value to be deleted is greater than the root's value,
            // then it lies in right subtree
        else if (value > root.value)
            root.right = deleteNode(root.right, value);

            // if value is same as root's value, then This is the node
            // to be deleted
        else {
            // node with only one child or no child
            if ((root.left == null) || (root.right == null)) {

                Node temp;
                if (root.left != null)
                    temp = root.left;
                else
                    temp = root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else // One child case
                    root = temp; // Copy the contents of the non-empty child

                temp = null;
            } else {
                // node with two children: Get the inorder successor (smallest
                // in the right subtree)
                Node temp = minValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.value = temp.value;

                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.value);
            }
        }

        // If the tree had only one node then return
        if (root == null)
            return root;

        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = balance(root);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && balance(root.left) >= 0)
            return rightRotate(root);

        // Left Right Case
        if (balance > 1 && balance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Right Case
        if (balance < -1 && balance(root.right) <= 0)
            return leftRotate(root);

        // Right Left Case
        if (balance < -1 && balance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public void preOrder(Node root) {
        if (root != null) {
            preOrder(root.left);
            System.out.printf("%d ", root.value);
            preOrder(root.right);
        }
    }

    public void print(Node root) {

        if (root == null) {
            System.out.println("(XXXXXX)");
            return;
        }

        int height = root.height,
                width = (int) Math.pow(2, height - 1);

        // Preparing variables for loop.
        List<Node> current = new ArrayList<Node>(1);
        List<Node> next = new ArrayList<Node>(2);
        current.add(root);

        final int maxHalfLength = 4;
        int elements = 1;

        StringBuilder sb = new StringBuilder(maxHalfLength * width);
        for (int i = 0; i < maxHalfLength * width; i++)
            sb.append(' ');
        String textBuffer;

        // Iterating through height levels.
        for (int i = 0; i < height; i++) {

            sb.setLength(maxHalfLength * ((int) Math.pow(2, height - 1 - i) - 1));

            // Creating spacer space indicator.
            textBuffer = sb.toString();

            // Print tree node elements
            for (Node n : current) {

                System.out.print(textBuffer);

                if (n == null) {

                    System.out.print("        ");
                    next.add(null);
                    next.add(null);

                } else {

                    System.out.printf("(%6d)", n.value);
                    next.add(n.left);
                    next.add(n.right);

                }

                System.out.print(textBuffer);

            }

            System.out.println();
            // Print tree node extensions for next level.
            if (i < height - 1) {

                for (Node n : current) {

                    System.out.print(textBuffer);

                    if (n == null)
                        System.out.print("        ");
                    else
                        System.out.printf("%s      %s",
                                n.left == null ? " " : "/", n.right == null ? " " : "\\");

                    System.out.print(textBuffer);

                }

                System.out.println();

            }

            // Renewing indicators for next run.
            elements *= 2;
            current = next;
            next = new ArrayList<Node>(elements);

        }

    }
}
