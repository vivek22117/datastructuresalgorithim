package com.doubledigit.algorithim.chapter1;

/**
 * Created by Vivek Kumar Mishra on 30/07/2018.
 */
public class LinkListDataStructure {

    private Node head = null;

    class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void sortedInsertion(Node newNode) {
        Node current;
        if (head == null || head.value >= newNode.value) {
            newNode.next = head;
            head = newNode;
        } else {
            current = head;
            while (current.next != null && current.next.value < newNode.value) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public void sortLinkList(LinkListDataStructure data) {
        Node head = data.head;
        Node current;

        if (head == null || head.next == null) {
            System.out.println("Sorting not required...");
        } else {
            current = head;
            while (current.next != null) {
                if (current.value < current.next.value) {
                    current = current.next;
                }
                current = current.next;
            }
        }

    }

    Node newNode(int value) {
        Node node = new Node(value);
        return node;
    }

    public void printLinkList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkListDataStructure linkList = new LinkListDataStructure();
        Node new_node;

        new_node = linkList.newNode(5);
        linkList.sortedInsertion(new_node);
        new_node = linkList.newNode(10);
        linkList.sortedInsertion(new_node);
        new_node = linkList.newNode(3);
        linkList.sortedInsertion(new_node);

        linkList.printLinkList();
    }

}
