package com.devcortes.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BinaryTree {

    private Node root;

    class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            Node leftChild = addRecursive(current.left, value);
            current.left = leftChild;
            leftChild.parent = current;
        } else if (value > current.value) {
            Node rightChild = addRecursive(current.right, value);
            current.right = rightChild;
            rightChild.parent = current;
        } else {
            return current;
        }

        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    private Node findNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            return current;
        }
        return value < current.value
                ? findNode(current.left, value)
                : findNode(current.right, value);
    }

    public Node findNode(int value) {
        return findNode(root, value);
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    /**   Обхід в глибину   **/
    // The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    // Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree
    public void traversePreOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    // Post-order traversal visits the left subtree, the right subtree, and the root node at the end
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + node.value);
        }
    }
    /**   Обхід в глибину   **/

    /**   Обхід в ширину   **/
    public void traverseLevelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(" " + node.value);

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
    /**   Обхід в ширину   **/

    public void print(Node node) {
        if (node != null) {
            print(node.left);
            System.out.print(node.value + " ");
            print(node.right);
        }
    }

    public Node findNextByOrderNode(Node node) {
        if (node == null) {
            return null;
        }

        if (node.parent == null && node.right == null) {
            return node;
        }

        if (node.right == null && node.value == node.parent.left.value) {
            return node.parent;
        } else if (node.right == null){
            while (node.parent != null && node.parent.value < node.value) {
                node = node.parent;
            }
            return node.parent;
        }
        return minRightNode(node.right);
    }

    private Node minRightNode(Node node) {
        return node.left == null ? node : minRightNode(node.left);
    }

    public List<Node> findPage(Node node, int limit) {
        if (node == null) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        if (node.right == null) {
            while (node.parent != null && node.parent.value < node.value) {
                node = node.parent;
            }
            nodes.add(node.parent);
            getPage(node.parent.right, nodes, limit);
        } else {
            getPage(node.right, nodes, limit);
        }
        return nodes;
    }

    private void getPage(Node node, List<Node> nodes, int limit) {
        if (node != null) {
            getPage(node.left, nodes, limit);
            if (nodes.size() == limit) {
                return;
            }
            nodes.add(node);
            getPage(node.right, nodes, limit);
        }
    }

    public boolean isBST(Node node) {
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int minValue, int maxValue) {
        if (Objects.isNull(node)) {
            return true;
        }

        if (node.value < minValue || node.value > maxValue) {
            return false;
        }

        return isBSTUtil(node.left, minValue, node.value )
                && isBSTUtil(node.right, node.value , maxValue);
    }

    public boolean isBSTSecond(Node node) {
        if (Objects.isNull(node)) {
            return true;
        }

        if ((Objects.nonNull(node.left) && getMaxValue(node.left) > node.value) || (Objects.nonNull(node.right) && getMinValue(node.right) < node.value)) {
            return false;
        }

        return isBSTSecond(node.left) && isBSTSecond(node.right);
    }

    private int getMaxValue(Node node) {
        return Objects.isNull(node.right) ? node.value : getMaxValue(node.right);
    }

    private int getMinValue(Node node) {
        return Objects.isNull(node.left) ? node.value : getMinValue(node.left);
    }
}
