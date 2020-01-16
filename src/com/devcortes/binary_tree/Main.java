package com.devcortes.binary_tree;

// Resource - https://www.baeldung.com/java-binary-tree
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
        bt.add(12);

        boolean i = bt.containsNode(8);
        boolean qw = bt.containsNode(10);
        bt.delete(6);
        i = bt.containsNode(8);
        qw = bt.containsNode(10);
        System.out.println();
    }
}
