package com.google.algo.linklist;

public class LinkListImpl<T> {

    private Node<T> head = null;
    private int size = 0;

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<T> reverseLinkList(Node<T> head) {
        Node<T> previous = null;

        while (head != null) {
            Node<T> next = head.getNext();
            head.setNext(previous);
            previous = head;
            head = next;
        }

        return previous;
    }
}
