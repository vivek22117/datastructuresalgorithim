package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

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
}
