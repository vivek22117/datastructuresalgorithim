package com.google.algo.tree;

public class Node<T> {

    private T data;
    private Node<T> leftNode;
    private Node<T> rightNode;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node<T> node) {
        this.leftNode = node;
    }

    public Node<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node<T> node) {
        this.rightNode = node;
    }

}
