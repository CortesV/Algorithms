package com.devcortes.modified_binary_tree;

public class NodeData {

    private int place;
    private String name;
    private int score;

    public NodeData() {

    }

    public NodeData(int place, String name, int score) {
        this.place = place;
        this.name = name;
        this.score = score;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
