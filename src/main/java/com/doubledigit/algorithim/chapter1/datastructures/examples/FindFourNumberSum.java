package com.doubledigit.algorithim.chapter1.datastructures.examples;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//input: [3, 6, 9, 7, 2, 4, 8, 1], output: []
public class FindFourNumberSum {
    private static final int[] GIVEN_ARRAY = {13, 6, 9, 7, 12, 4, 8, 1};
    private static final int TARGET = 22;


    public static void main(String[] args) {
        List<Integer[]> fourNumberSum = getFourNumberSum(GIVEN_ARRAY, TARGET);

        fourNumberSum.forEach(e -> {
            System.out.println("Quarplet = " + e[0] + " " + e[1] + " " + e[2] + " " + e[3]);
        });
    }

    private static List<Integer[]> getFourNumberSum(int[] givenArray, int target) {
        Arrays.sort(givenArray);
        int N = givenArray.length;
        List<Integer[]> result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int k = i + 1; k < N; k++) {
                int currentSum = givenArray[i] + givenArray[k];
                int leftIndx = k + 1;
                int rightIndx = N - 1;

                while (leftIndx < rightIndx) {
                    int tempSum = currentSum + givenArray[leftIndx] + givenArray[rightIndx];
                    if (tempSum == target) {
                        Integer[] indexes = {givenArray[i], givenArray[k], givenArray[leftIndx], givenArray[rightIndx]};
                        result.add(indexes);
                        leftIndx++;
                        rightIndx--;
                    }
                    if (tempSum < target) {
                        leftIndx++;
                    } else {
                        rightIndx--;
                    }
                }
            }
        }
        return result;
    }
}
