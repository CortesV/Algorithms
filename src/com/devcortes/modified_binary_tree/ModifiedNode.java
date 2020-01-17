package com.devcortes.modified_binary_tree;


public class ModifiedNode {

    private int score;

    private ModifiedNode left;
    private ModifiedNode right;

    ModifiedNode(int value) {
        this.score = value;
        right = null;
        left = null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ModifiedNode getLeft() {
        return left;
    }

    public void setLeft(ModifiedNode left) {
        this.left = left;
    }

    public ModifiedNode getRight() {
        return right;
    }

    public void setRight(ModifiedNode right) {
        this.right = right;
    }
}
