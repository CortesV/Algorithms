package com.devcortes.modified_binary_tree;


public class ModifiedBinaryTree {

    private ModifiedNode root;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private ModifiedNode addRecursive(ModifiedNode current, int value) {
        if (current == null) {
            return new ModifiedNode(value);
        }

        if (value < current.getScore()) {
            current.setLeft(addRecursive(current.getLeft(), value));
        } else if (value > current.getScore()) {
            current.setRight(addRecursive(current.getRight(), value));
        } else {
            return current;
        }

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

        sortDescTree(modifiedNode.getLeft());
        System.out.print(modifiedNode.getScore() + " ");
        sortDescTree(modifiedNode.getRight());
    }
}
