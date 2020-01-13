package com.devcortes.list;

public class LinkedList {

    public Node head;

    static class Node {
        public String data;
        public Node next;

        public Node(String data) {
            this.data = data;
            next = null;
        }
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}
