package com.doubledigit.algorithim.chapter1.datastructures.examples;

import java.util.Arrays;

public class SmallestDifferenceProgram {
    private static final int[] inputArrayA = {4, 6, 12, -3, 8, 5, -7};
    private static final int[] inputArrayB = {11, 9, -1, 24, 16, -19};

    public static void main(String[] args) {
        Integer[] smallestDifference = getSmallestDifference(inputArrayA, inputArrayB);

        System.out.println("num1 = " + smallestDifference[0]);
        System.out.println("num2 = " + smallestDifference[1]);
    }

    private static Integer[] getSmallestDifference(int[] inputArrayA, int[] inputArrayB) {
        Arrays.sort(inputArrayA);
        Arrays.sort(inputArrayB);

        int indxA = 0;
        int indxB = 0;

        Integer diff = Integer.MAX_VALUE;
        Integer[] result = new Integer[2];

        while (indxA < inputArrayA.length && indxB < inputArrayB.length) {
            int firstNum = inputArrayA[indxA];
            int secondNum = inputArrayB[indxB];

            Integer currentDiff = Integer.MAX_VALUE;

            if (firstNum < secondNum) {
                currentDiff = secondNum - firstNum;
                indxA++;
            } else if (secondNum < firstNum) {
                currentDiff = firstNum - secondNum;
                indxB++;
            } else {
                return new Integer[]{firstNum, secondNum};
            }

            if (currentDiff < diff) {
                diff = currentDiff;
                result = new Integer[]{firstNum, secondNum};
            }
        }

        return result;

    }
}
