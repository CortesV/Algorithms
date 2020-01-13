package com.devcortes.list;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new LinkedList.Node("A");
        list.head.next = new LinkedList.Node("B");
        list.head.next.next = new LinkedList.Node("C");
        list.head.next.next.next = new LinkedList.Node("D");
        list.head.next.next.next.next = new LinkedList.Node("E");

        list.printList(list.head);

        LinkedList.Node prev = null;
        LinkedList.Node current = list.head;


        LinkedList.Node reversed = simple(current, prev);
        list.printList(reversed);

        prev = null;
        current = reversed;
        list.printList(recur(current, prev));
    }

    public static LinkedList.Node simple(LinkedList.Node current, LinkedList.Node prev) {
        LinkedList.Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public static LinkedList.Node recur(LinkedList.Node current, LinkedList.Node prev) {
        if (current == null) {
            return prev;
        }
        LinkedList.Node next = current.next;
        current.next = prev;
        prev = current;
        current = next;
        return recur(current, prev);
    }
}
