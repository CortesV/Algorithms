package com.devcortes.modified_binary_tree;


public class ModifiedNode {

    private int score;
    private int currentPos;
    private int size;

    private ModifiedNode left;
    private ModifiedNode right;

    ModifiedNode(int value, int size) {
        this.score = value;
        this.size = size;
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

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
