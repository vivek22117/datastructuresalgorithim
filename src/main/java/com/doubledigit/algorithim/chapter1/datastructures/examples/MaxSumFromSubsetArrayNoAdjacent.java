package com.doubledigit.algorithim.chapter1.datastructures.examples;


//inputData: [4, 12, 11, 10, 9, 14, 6], output: [4, 11, 9, 6] : 30
public class MaxSumFromSubsetArrayNoAdjacent {

    private static final int[] inputData = {14, 12, 2, 13, 9, 1, 0};

    public static void main(String[] args) {
        int maxSum = maxSumSubsetWithNoAdjacent(inputData);
        int maxSumSecond = maxSumSubsetWithNoAdjacentEfficient(inputData);
        System.out.println("maxSum = " + maxSum);
        System.out.println("maxSumSecond = " + maxSumSecond);
    }

    private static int maxSumSubsetWithNoAdjacentEfficient(int[] inputData) {
        if(inputData.length == 0){
            return 0;
        } else if(inputData.length == 1){
            return inputData[0];
        }

        int first = inputData[0];
        int second = Math.max(first, inputData[1]);

        for (int i = 2; i< inputData.length; i++){
            int current = Math.max(second, first + inputData[i]);
            first = second;
            second = current;
        }
        return second;
    }

    //time: O(n) | space: O(n)
    private static int maxSumSubsetWithNoAdjacent(int[] inputData) {
        if(inputData.length == 0){
            return 0;
        } else if(inputData.length == 1){
            return inputData[0];
        }

        int[] maxSums = inputData.clone();
        maxSums[1] = Math.max(inputData[0], inputData[1]);
        for (int i = 2; i< inputData.length; i++){
            maxSums[i] = Math.max(maxSums[i-1], maxSums[i-2] + inputData[i]);

        }

        return maxSums[inputData.length -1];
    }


}
