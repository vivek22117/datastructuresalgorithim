package com.doubledigit.algorithim.chapter1.datastructures;

import java.lang.reflect.Array;

public class CircularQueue<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 40;

    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public boolean isEmpty() {
        return headIndex == SPECIAL_EMPTY_VALUE;
    }

    public boolean isFull() {
        int nextIndex = (tailIndex + 1) % elements.length;

        return nextIndex == headIndex;
    }

    public void enqueue(T data) throws QueueOverFlowException {
        if (isFull()) {
            throw new QueueOverFlowException();
        }

        tailIndex = (tailIndex + 1) % elements.length;
        elements[tailIndex] = data;

        if (headIndex == SPECIAL_EMPTY_VALUE) {
            headIndex = tailIndex;
        }
    }

    public T dequeue() throws QueueUnderFlowException {
        if (isEmpty()) {
            throw new QueueUnderFlowException();
        }

        T data = elements[headIndex];

        if (headIndex == tailIndex) {
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1) % elements.length;
        }
        return data;
    }

    public static class QueueOverFlowException extends Exception {
        public QueueOverFlowException() {
            super();
        }
    }

    public static class QueueUnderFlowException extends Exception {
        public QueueUnderFlowException() {

        }
    }
}
