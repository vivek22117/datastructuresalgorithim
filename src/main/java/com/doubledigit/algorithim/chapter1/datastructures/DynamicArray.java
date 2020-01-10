package com.doubledigit.algorithim.chapter1.datastructures;

public class DynamicArray {

    private int count;
    private int[] elements;

    public DynamicArray(int size) {
        elements = new int[size];
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }
    }

    public void insertElements(int element) {
        if (elements.length == count) {
            int[] newElements = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        } else {
            elements[count++] = element;
        }
    }

    public int indexOf(int element) {
        for (int i = 0; i < count; i++) {
            if (elements[i] == element) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void removeElement(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }

        for (int i = index; i < count; i++) {
            elements[i] = elements[i + 1];
        }
    }
}
