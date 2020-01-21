package com.devcortes.simple_tree;

import java.util.ArrayList;
import java.util.List;

public class SimpleTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private class Node {
        private int value;
        private String name;
        private Node parent;
        private List<Node> children = new ArrayList<>();

        public Node(String name, int value) {
            this.value = value;
            this.name = name;
        }

        private Node addChild(Node child) {
            child.parent = this;
            this.children.add(child);
            return child;
        }

        private void addChildren(List<Node> children) {
            children.forEach(node -> node.parent = this);
            this.children.addAll(children);
        }
    }

    public Node createTree() {
        Node root = new Node("root", 12);

        Node node1 = root.addChild(new Node("node 1", 23));

        Node node11 = node1.addChild(new Node("node 11", 12));
        Node node111 = node11.addChild(new Node("node 111",1));
        Node node112 = node11.addChild(new Node("node 112", 21));

        Node node12 = node1.addChild(new Node("node 12", 434));

        Node node2 = root.addChild(new Node("node 2", 3434));

        Node node21 = node2.addChild(new Node("node 21", 54));
        Node node211 = node2.addChild(new Node("node 22", 545));
        return root;
    }

    public void printTree(Node node, String appender) {
        System.out.println(appender + node.name);
        node.children.forEach(each ->  printTree(each, appender + appender));
    }

}
