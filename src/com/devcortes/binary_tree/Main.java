package com.devcortes.binary_tree;

public class Main {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(6);
        bt.add(4);
        bt.add(10);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);
        bt.add(8);

        boolean b = bt.containsNode(123123);

        bt.delete(9);

        int a = 1;
    }
}