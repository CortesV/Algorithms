package com.devcortes.modified_binary_tree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player(123123, "asd"));
        players.add(new Player(12, "fghth"));
        players.add(new Player(34, "werasd"));
        players.add(new Player(123, "xv"));
        players.add(new Player(78, "hjk"));
        players.add(new Player(55, "asasdd"));
        players.add(new Player(1, "asasdd"));

        ModifiedBinaryTree binaryTree = new ModifiedBinaryTree();
        binaryTree.addWithGreatestValueInRoot(1000);
        binaryTree.addWithGreatestValueInRoot(234);
        binaryTree.addWithGreatestValueInRoot(1);
        binaryTree.addWithGreatestValueInRoot(57);
        binaryTree.addWithGreatestValueInRoot(34);
        binaryTree.addWithGreatestValueInRoot(987);
        binaryTree.addWithGreatestValueInRoot(65);
        binaryTree.addWithGreatestValueInRoot(21);
        binaryTree.addWithGreatestValueInRoot(12);
        binaryTree.addWithGreatestValueInRoot(1200);
        binaryTree.addWithGreatestValueInRoot(1201);
        binaryTree.addWithGreatestValueInRoot(1202);
        binaryTree.addWithGreatestValueInRoot(1204);
        binaryTree.addWithGreatestValueInRoot(3000);
        binaryTree.addWithGreatestValueInRoot(1500);
        binaryTree.addWithGreatestValueInRoot(2000);
        binaryTree.addWithGreatestValueInRoot(1203);
        binaryTree.sortDescTree();

    }
}

class Player implements Comparable<Player>{
    int score;
    String name;

    public Player(int score, String name) {
        this.score = score;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "score=" + score +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        if (this.score > o.score) {
            return 1;
        }
        if (this.score < o.score) {
            return -1;
        }
        return 0;
    }
}
