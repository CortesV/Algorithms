package com.devcortes.binary_tree;

// Resource - https://www.baeldung.com/java-binary-tree
public class Main {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.add(50);
        bt.add(70);
        bt.add(55);
        bt.add(80);
        bt.add(51);
        bt.add(60);
        bt.add(71);
        bt.add(90);
        bt.add(73);
        bt.add(40);
        bt.add(45);
        bt.add(49);
        bt.add(41);
        bt.add(20);
        bt.add(30);
        bt.add(10);

        bt.print(bt.getRoot());
        System.out.println();
        BinaryTree.Node firstCase = bt.findNextByOrderNode(bt.findNode(10));
        System.out.println("First case: node - " + bt.findNode(10) + ", result node - " + firstCase);
        BinaryTree.Node secondCase = bt.findNextByOrderNode(bt.findNode(49));
        System.out.println("Second case: node - " + bt.findNode(49) + ", result node - " + secondCase);
        BinaryTree.Node thirdCase = bt.findNextByOrderNode(bt.findNode(50));
        System.out.println("Third case: node - " + bt.findNode(50) + ", result node - " + thirdCase);
    }
}
