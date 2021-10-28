package com.doubledigit.algorithim.chapter1.datastructures;

public class LinkListDSWithHeadAndTail<T> {
    private volatile Node<T> head = null;
    private volatile Node<T> tail = null;
    private int size;
    private int numberOfNodes;

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int countNodes() {
        if(head == null) {
            return 0;
        } else {
            Node<T> curr = head;
            int counter = 0;
            while (curr != null) {
                curr = curr.next;
                counter++;
            }
            return counter;
        }
    }

    public void append(T data) {
        Node<T> node = new Node<>(data);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size += 1;
    }

    public void prepend(T data) {
        Node<T> node = new Node<>(data);

        if (isEmpty()) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        size += 1;
    }

    public int indexOf(T data) {
        int index = 0;
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.data.equals(data)) {
                return index;
            }
            currentNode = currentNode.next;
            index += 1;
        }
        return -1;
    }

    public boolean contains(T data) {
        return indexOf(data) != -1;
    }

    public void removeFirst() throws LinkListUnderFlowException {
        if (isEmpty()) {
            throw new LinkListUnderFlowException();
        }

        if (head == tail) {
            head = tail = null;
            return;
        }

        Node<T> second = head.next;
        head.next = null;
        head = second;

        size -= 1;
    }

    public void removeLast() throws LinkListUnderFlowException {
        if (isEmpty())
            throw new LinkListUnderFlowException();

        if (head == tail){
            head = tail = null;
            return;
        }

        Node<T> previousNode = getPreviousNode(tail);
        tail = previousNode;
        previousNode.next = null;               //Required so that GC will clear the memory of last node

        size -= 1;
    }

    private Node<T> getPreviousNode(Node<T> tail) {
        Node<T> currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next == tail)
                return currentNode;
            currentNode = currentNode.next;
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[size];
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            array[index++] = current.data;          //index++    will give index to array and increment index with 1
            current = current.next;
        }
        return array;
    }


    static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

        public Node() {
        }
    }

    public static class LinkListUnderFlowException extends Exception {
        public LinkListUnderFlowException() {
            super();
        }
    }
}
