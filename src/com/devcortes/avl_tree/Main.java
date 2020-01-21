package com.devcortes.avl_tree;

public class Main {

    public static void main(String args[]) {
        AVLTree tree = new AVLTree();
        tree.add(10);
        tree.add(20);
        tree.add(30);
        tree.add(40);
        tree.add(50);
        tree.add(60);
        tree.add(70);
        tree.add(80);
        tree.add(90);
        tree.add(100);
        tree.add(25);
        tree.add(19);
        tree.add(1);

        tree.preOrder(tree.getRoot());
    }
}
