package com.doubledigit.algorithim.chapter1.sortingAlgo;

import java.util.stream.Stream;

/**
 * Created by Vivek Kumar Mishra on 07/10/2018.
 */
public class BubbleSort {

    private static int[] inputArray = {3, 6, 8, 2, 1, 5, 7};

    public static void main(String[] args) {
        BubbleSort.bubbleSort(inputArray);
    }

    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            boolean swapped = false;
            for (int j = list.length - 1; j > i; j--) {
                if (list[j] < list[j - 1]) {
                    swap(list, j, j - 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        printList(list);
    }

    private static void printList(int[] list) {
        Stream.iterate(0, e -> e + 1).limit(list.length).forEach(e -> {
            System.out.println(list[e]);
        });
    }

    private static void swap(int[] list, int j, int i) {
        int temp = list[j];
        list[j] = list[i];
        list[i] = temp;
    }
}
