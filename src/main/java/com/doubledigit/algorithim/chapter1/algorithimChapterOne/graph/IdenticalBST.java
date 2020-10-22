package com.doubledigit.algorithim.chapter1.algorithimChapterOne.graph;

/**
 * Created by Vivek Kumar Mishra on 26/09/2018.
 */
public class IdenticalBST {
    private String value;

    public boolean sameTree(Node<Integer> one, Node<Integer> two){
        if(one == null && two == null){
            return true;
        }

        if(one == null){
            return false;
        } else if(two == null){
            return false;
        }

        if(sameTree(one.leftNode,two.leftNode) && sameTree(one.rightNode, two.rightNode)){
            return one.getElement().equals(two.getElement());
        }
        return false;
    }

    public static class Node<T>{

        private T element;
        private Node<T> leftNode;
        private Node<T> rightNode;


        public void addNodes(Node<T> leftNode, Node<T> rightNode){
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node<T> getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node<T> leftNode) {
            this.leftNode = leftNode;
        }

        public Node<T> getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node<T> rightNode) {
            this.rightNode = rightNode;
        }
    }
}
