package com.doubledigit.algorithim.chapter1.datastructures;

import java.lang.reflect.Array;

public class CircularQueue<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static int MAX_SIZE = 44;
    private int numberOfElements = 0;

    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz) {
        this.elements = (T[]) Array.newInstance(clazz, MAX_SIZE);
    }

    public CircularQueue(Class<T> clazz, Integer size) {
        if (size == null || size <= 0) {
            throw new IllegalArgumentException();
        }
        this.elements = (T[]) Array.newInstance(clazz, size);
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
        numberOfElements++;
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
        numberOfElements--;
        return data;
    }

    public int numberOfElements() {
        return numberOfElements;
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
