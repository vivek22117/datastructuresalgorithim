package com.doubledigit.algorithim.chapter1.datastructures;

public class LinkListDataStructure<T> {

    private volatile Node<T> head = null;

    public Node<T> getHead() {
        return head;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void append(T data) {
        if (isEmpty()) {
            head = new Node<>(data);
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    public void prepend(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    public void delete(T data) {
        if (isEmpty()) {
            return;
        }

        Node<T> current = head;
        while (current != null) {
            if (current.data == data) {
                current = current.next;
                return;
            } else {
                current = current.next;
            }
        }
    }

    public class Node<E> {
        private E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}

