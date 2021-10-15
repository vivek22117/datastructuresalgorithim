package com.google.algo.array;

public class FindMissingNumber {

    public static void main(String[] args) {
        FindMissingNumber missingNum = new FindMissingNumber();
        int[] input = {1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16};
        int output = missingNum.findMissionNum(input);
        System.out.println(output);
    }

    public int findMissionNum(int[] inputArray) {
        int sum1 = 0;
        int sum2 = 0;
        int N = inputArray.length;
        for(int i : inputArray) {
            sum1 += i;
        }
        sum2 = N*(N+1)/2;
        int diff = sum2 - sum1;
        System.out.println("Missing number is: " + diff);
        return diff;
    }
}
