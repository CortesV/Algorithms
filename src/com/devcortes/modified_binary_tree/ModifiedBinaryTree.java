package com.devcortes.modified_binary_tree;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ModifiedBinaryTree {

    private ModifiedNode root;

    public void addWithGreatestValueInRoot(int value) {
        if (root == null) {
            root = new ModifiedNode(value, 1);
            return;
        }
        if (root.getScore() < value) {
            ModifiedNode newRoot = new ModifiedNode(value, root.getSize() + 1);
            newRoot.setLeft(root);
            root = newRoot;
            return;
        }
        root = addRecursive(root, value);
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private ModifiedNode addRecursive(ModifiedNode current, int value) {
        if (current == null) {
            return new ModifiedNode(value, 1);
        }

        if (value < current.getScore()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getScore()) {
            current.setRight(addRecursive(current.getRight(), value));
        }
        current.setSize(size(current.getRight()) + size(current.getLeft()) + 1);
        return current;
    }

    public void sortDescTree() {
        sortDescTree(this.root);
        System.out.println();
    }

    private void sortDescTree(ModifiedNode modifiedNode) {
        if (modifiedNode == null) {
            return;
        }

        sortDescTree(modifiedNode.getRight());
        System.out.print(modifiedNode.getScore() + " ");
        sortDescTree(modifiedNode.getLeft());
    }

    public void sortAscTree() {
        sortAscTree(this.root);
        System.out.println();
    }

    private void sortAscTree(ModifiedNode modifiedNode) {
        if (modifiedNode == null) {
            return;
        }

        sortAscTree(modifiedNode.getLeft());
        System.out.print(modifiedNode.getScore() + " ");
        sortAscTree(modifiedNode.getRight());
    }

    private int size(ModifiedNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.getSize();
        }
    }

    public void find() {
        AtomicInteger integer = new AtomicInteger();
        ModifiedNode modifiedNode = find(this.root, integer, 2);
        System.out.println(modifiedNode.getScore());
    }

    private ModifiedNode find(ModifiedNode modifiedNode, AtomicInteger integer, int pos) {
        if (modifiedNode == null) {
            return null;
        }

        ModifiedNode node = find(modifiedNode.getRight(), integer, pos);
        if(integer.get() != pos) {
            integer.incrementAndGet();
            node = modifiedNode;
        }
        if (integer.get() == pos) {
            return node;
        } else {
            return find(modifiedNode.getLeft(), integer, pos);
        }
    }

    public void nodesLessThan(int number) {
        ArrayList<ModifiedNode> modifiedNodes = new ArrayList<>();
        nodesLessThan(root, number, modifiedNodes);
        for (ModifiedNode modifiedNode : modifiedNodes) {
            System.out.println(modifiedNode.getScore());
        }
    }

    private void nodesLessThan(ModifiedNode root, int number, ArrayList<ModifiedNode> modifiedNodes) {
        if (root == null) {
            return;
        }

        if (root.getScore() == number) {
            copyElements(root.getLeft(), modifiedNodes);
            return;
        }

        if (root.getScore() > number) {
            nodesLessThan(root.getLeft(), number, modifiedNodes);
        }
        if (root.getScore() < number) {
            copyElements(root.getLeft(), modifiedNodes);
        }
    }

    private void copyElements(ModifiedNode modifiedNode, ArrayList<ModifiedNode> nodes) {
        if (modifiedNode == null) {
            return;
        }
        copyElements(modifiedNode.getLeft(), nodes);
        nodes.add(modifiedNode);
        copyElements(modifiedNode.getRight(), nodes);
    }
}
