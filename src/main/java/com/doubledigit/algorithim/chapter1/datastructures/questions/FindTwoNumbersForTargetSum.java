package com.doubledigit.algorithim.chapter1.datastructures.questions;

import java.util.*;

// Given input array is [3, -1, 5, 6, 8, 11, -2, 9], TargetSum 10, output [11, -1]
public class FindTwoNumbersForTargetSum {

    private static int[] inputData = {3, 1, 6, -11, 8, 11, 0, -4, -3, 17, 4};
    private static final int TARGET_SUM = 10;

    public static void main(String[] args) {
//        List<Integer> result = twoNumberSumWithExtraSpace(inputData, TARGET_SUM);
        List<Integer> result = twoNumberSumWithoutSpace(inputData, TARGET_SUM);

        printResult(result);


    }

    private static void printResult(List<Integer> result) {
        result.stream().forEach(i -> {
            System.out.println("i = " + i);
        });
    }

    //O(n) time | O(n) space
    private static List<Integer> twoNumberSumWithExtraSpace(int[] inputData, int targetSum) {
        Map<Integer, Boolean> tempData = new Hashtable<>();

        for (int i = 0; i < inputData.length; i++) {
            int potentialMatch = targetSum - inputData[i];

            if (tempData.containsKey(potentialMatch)) {
                return Arrays.asList(inputData[i], potentialMatch);
            } else {
                tempData.put(inputData[i], true);
            }
        }
        return null;
    }

    private static List<Integer> twoNumberSumWithoutSpace(int[] inputData, int targetSum) {
        Arrays.sort(inputData);

        int leftIndex = 0;
        int rightIndex = inputData.length - 1;

        while (leftIndex < rightIndex) {
            int currentSum = inputData[leftIndex] + inputData[rightIndex];

            if (currentSum == targetSum) {
                return Arrays.asList(inputData[leftIndex], inputData[rightIndex]);
            }

            if (currentSum < targetSum) {
                leftIndex += 1;
            } else {
                rightIndex -= 1;
            }
        }
        return new ArrayList<>();
    }
}
