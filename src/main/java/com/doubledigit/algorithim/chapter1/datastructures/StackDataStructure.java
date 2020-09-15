package com.doubledigit.algorithim.chapter1.datastructures;

public class StackDataStructure<T> {

    private static int MAX_SIZE = 44;

    private Element<T> top;
    private int stackSize = 0;

    public int getStackSize() {
        return stackSize;
    }

    public boolean isEmpty() {
        return stackSize == 0;
    }

    public void push(T data) throws StackOverFlowException {
        if (stackSize == MAX_SIZE) {
            throw new StackOverFlowException();
        }

        top = new Element(data, top);
        stackSize++;
    }

    public T pop() throws StackUnderFlowException {
        if (stackSize == 0) {
            throw new StackUnderFlowException();
        }

        T data = top.data;
        top = top.next;

        stackSize--;
        return data;
    }

    public T peek() throws StackUnderFlowException {
        if (stackSize == 0) {
            throw new StackUnderFlowException();
        }
        return top.data;
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
