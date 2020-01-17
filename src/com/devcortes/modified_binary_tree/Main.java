package com.devcortes.modified_binary_tree;

public class Main {

    public static void main(String[] args) {
        int[] arr = {50, 30, 70, 15, 7, 62, 22, 35, 87, 22, 31};
        ModifiedBinaryTree tree = new ModifiedBinaryTree();
        for(int num : arr){
            tree.add(num);
        }
        tree.sortDescTree();
        tree.sortAscTree();
    }
}
