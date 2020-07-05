package com.devcortes.binary_tree;

import java.util.List;

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
        System.out.println("IS TREE BST? ANSWER - " + bt.isBST(bt.getRoot()));
        System.out.println("IS TREE BST? SECOND ANSWER - " + bt.isBSTSecond(bt.getRoot()));
        System.out.println();
        BinaryTree.Node firstCase = bt.findNextByOrderNode(bt.findNode(10));
        System.out.println("First case: node - " + bt.findNode(10) + ", result node - " + firstCase);
        BinaryTree.Node secondCase = bt.findNextByOrderNode(bt.findNode(49));
        System.out.println("Second case: node - " + bt.findNode(49) + ", result node - " + secondCase);
        BinaryTree.Node thirdCase = bt.findNextByOrderNode(bt.findNode(50));
        System.out.println("Third case: node - " + bt.findNode(50) + ", result node - " + thirdCase);

        System.out.println("\n\n\nFirst case: node - " + bt.findNode(50));
        List<BinaryTree.Node> page = bt.findPage(bt.findNode(50), 5);
        for (BinaryTree.Node node : page) {
            System.out.println(node);
        }
        System.out.println("\nSecond case: node - " + bt.findNode(49));
        page = bt.findPage(bt.findNode(49), 5);
        for (BinaryTree.Node node : page) {
            System.out.println(node);
        }
    }
}
