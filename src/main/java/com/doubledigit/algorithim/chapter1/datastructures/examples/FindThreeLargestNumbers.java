package com.doubledigit.algorithim.chapter1.datastructures.examples;

//Input [5, 4, 23, -2, -14, 67, 118, 0, 3, 9, -5, 36] output: [36, 67, 118]
public class FindThreeLargestNumbers {
    private static int[] inputData = {5, 4, 43, -2, -14, 67, 18, 0, 83, 9, -5, 36};

    public static void main(String[] args) {
        int[] threeLargestNum = findThreeLargestNum(inputData);

        for (int value : threeLargestNum) {
            System.out.println("value = " + value);
        }
    }

    //complexity time: O(n) | space: O(1)
    private static int[] findThreeLargestNum(int[] inputData) {
        int[] threeLargestNumber = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int value : inputData) {
            updateThreeLargestNumber(threeLargestNumber, value);
        }
        return threeLargestNumber;
    }

    private static void updateThreeLargestNumber(int[] threelargestNumber, int num) {
        if (num > threelargestNumber[2]) {
            shiftLargestNumbers(threelargestNumber, num, 2);
        } else if (num > threelargestNumber[1]) {
            shiftLargestNumbers(threelargestNumber, num, 1);
        } else if (num > threelargestNumber[0]) {
            shiftLargestNumbers(threelargestNumber, num, 0);
        }
    }

    private static void shiftLargestNumbers(int[] threelargestNumber, int num, int index) {
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                threelargestNumber[i] = num;
            } else {
                threelargestNumber[i] = threelargestNumber[i + 1];
            }
        }
    }
}
