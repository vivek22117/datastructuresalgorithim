package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class FindMaxConsecutiveOnes {

    private static int[] inputData = {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0};

    public static void main(String[] args) {
        int N = inputData.length;
        int i = 0;
        int max_length = Integer.MIN_VALUE;

        for (int e = 0; e < N; e++) {
            if (inputData[e] == 1) {
                int r = e + 1;
                int count = 1;
                while (r < N) {
                    if (inputData[r] != 1) break;
                    count = count + 1;
                    r++;
                }
                max_length = Math.max(max_length, count);
                e = r;
            }
        }
        System.out.println("Maximum number of One's are: " + max_length);
    }
}
