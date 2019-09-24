package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class FindMaxSumOfSubArray {

    private static int[] inputData = {6, 5, 6, -3, 1, 8, -4, 9, 5};

    public static void main(String[] args) {
        int N = inputData.length;
        int i = 0;
        int sum = Integer.MIN_VALUE;

        for (int e = 0; e < N; e++) {
            if (inputData[e] > 0) {
                int r = e + 1;
                int interSum = inputData[e];
                while (r < N) {
                    if (inputData[r] < 0) break;
                    interSum = interSum + inputData[r];
                    r++;
                }
                sum = Math.max(sum, interSum);
                e = r;
            }
        }
        System.out.println("Max sum of sub array is: " + sum);
    }
}
