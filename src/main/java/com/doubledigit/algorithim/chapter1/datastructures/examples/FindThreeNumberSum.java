package com.doubledigit.algorithim.chapter1.datastructures.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Input [3, -11, 0, 5, -8, 4, 7, 1, 2, -9]
public class FindThreeNumberSum {
    private static final int[] inputData = {3, -11, 0, 5, -8, 4, 7, 1, 2, -9};
    private static final int TARGET_SUM = 8;

    public static void main(String[] args) {
        List<Integer[]> threeSumArray = getThreeSumArray(inputData, TARGET_SUM);

        threeSumArray.stream().forEach(data -> {
            System.out.println("Value1 = " + data[0] + ", Value2 = " + data[1] + ", Value3 = " + data[2] + "\n");
        });
    }

    private static List<Integer[]> getThreeSumArray(int[] inputData, int targetSum) {
        Arrays.sort(inputData);
        List<Integer[]> threeSumArrays = new ArrayList<>();

        for (int i = 0; i < inputData.length - 2; i++) {
            int leftPntr = i + 1;
            int rightPntr = inputData.length - 1;

            while (leftPntr < rightPntr) {
                int currentSum = inputData[i] + inputData[leftPntr] + inputData[rightPntr];
                if (targetSum == currentSum) {
                    Integer[] newTriplet = {inputData[i], inputData[leftPntr], inputData[rightPntr]};
                    threeSumArrays.add(newTriplet);
                    leftPntr++;
                    rightPntr--;
                }
                if (currentSum < targetSum) {
                    leftPntr++;
                } else {
                    rightPntr--;
                }
            }
        }
        return threeSumArrays;
    }
}
