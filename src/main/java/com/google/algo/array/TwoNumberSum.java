package com.google.algo.array;

import java.util.Arrays;

public class TwoNumberSum {

    public static void main(String[] args) {
        TwoNumberSum twoSum = new TwoNumberSum();
        int[] input = {3, 7, 9, 1, 11, 15};
        int[] result = twoSum.findSum(input, 20);
        System.out.println(Arrays.toString(result));
    }

    public int[] findSum(int[] data, int target) {
        for(int i=0; i<data.length; i++) {
            for(int j=i+1; j<data.length; j++) {
                if(data[i] + data[j] == target) {
                    return new int[]{i ,j};
                }
            }
        }

        throw new IllegalArgumentException("No solution found!");
    }
}
