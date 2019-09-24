package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

import static java.util.Arrays.sort;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class SumOfNumbersInString {

    private static String inputData = "sdfse567idsi23iisodfif23";

    public static void main(String[] args) {
        int N = inputData.length();
        int sum = 0;
        int count = 0;
        boolean isDigit = false;
        for (int e = 0; e < N; e++) {
            if (Character.isDigit(inputData.charAt(e))) {
                count = count + 1;
                isDigit = true;
            } else {
                if (isDigit) {
                    sum = sum + Integer.parseInt(inputData.substring(e - count, e));
                    isDigit = false;
                    count = 0;
                }
            }

        }
        if(count > 0 || isDigit){
            sum = sum + Integer.parseInt(inputData.substring(N - count, N));
        }
        System.out.println("Sum of numbers in the string is: " + sum);
    }
    
    private static void getIndexOfLowestOccurrencesInArrayElements(int[] inputElements) {
        sort(inputElements);
        int[][] output = new int[2][3];
        int i = 0;
        while (i < inputElements.length) {
            int j = inputElements[i];
            int valueCount = 1;
            i = i + 1;

            if (i > inputElements.length - 1) break;

            while (inputElements[i] == j) {
                valueCount = valueCount + 1;
                i = i + 1;
                if (i > inputElements.length - 1) break;
            }
            if (output[0][2] == 0) {
                output[0][0] = i - 1;
                output[0][1] = inputElements[i - 1];
                output[0][2] = valueCount;
            } else if (output[1][2] == 0) {
                output[1][0] = i - 1;
                output[1][1] = inputElements[i - 1];
                output[1][2] = valueCount;
            } else if (output[0][2] >= valueCount && output[0][2] > output[1][2]) {
                output[0][0] = i - 1;
                output[0][1] = inputElements[i - 1];
                output[0][2] = valueCount;
            } else if (output[1][2] >= valueCount) {
                output[1][0] = i - 1;
                output[1][1] = inputElements[i - 1];
                output[1][2] = valueCount;
            }
        }
        System.out.println("Element is " + output[0][1] + " and Frequency is " + output[0][2] + "\n"
                + "Element is " + output[1][1] + " and Frequency is " + output[1][2]);

    }
}
