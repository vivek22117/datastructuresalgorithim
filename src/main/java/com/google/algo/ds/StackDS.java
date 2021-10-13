package com.google.algo.ds;

public class StackDS<T> {

    private static final int MAX_SIZE = 44;

    private Element<T> top;
    private int stackSize = 0;


    public boolean isEmpty(){
        return stackSize == 0;
    }

    public int getStackSize() {
        return stackSize;
    }



    public static class Element<T> {
        private T data;
        private Element next;

        public Element(T data, Element next) {
            this.data = data;
            this.next = next;
        }
    }

    public static class StackOverFlowException extends Exception {
        public StackOverFlowException() {
            super();
        }
    }

    public static class StackUnderFlowException extends Exception {
        public StackUnderFlowException() {
            super();
        }
    }
}

