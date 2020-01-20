package com.devcortes.avl_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) {
        AVLTree t = new AVLTree();
        AVLTree.Node root = null;
        while (true) {
            System.out.println("(1) Insert");
            System.out.println("(2) Delete");

            try {
                BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
                String s = bufferRead.readLine();

                if (Integer.parseInt(s) == 1) {
                    System.out.print("Value to be inserted: ");
                    t.add(Integer.parseInt(bufferRead.readLine()));
                }
                else if (Integer.parseInt(s) == 2) {
                    System.out.print("Value to be deleted: ");
                    t.deleteNode(Integer.parseInt(bufferRead.readLine()));
                }
                else {
                    System.out.println("Invalid choice, try again!");
                    continue;
                }

                t.print(t.getRoot());
            }
            catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
