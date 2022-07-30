package com.amazo;

public class SortSpecificPattern {

    private static final int[] inputData = {5, 4, 2, 3, 1};
//    private static final int[] inputData = {5, 4, 2, 3, 5}; 4,5,1,
//    private static final int[] inputData = {1, 4, 3, 4, 5}; 3,4,4
//    private static final int[] inputData = {1, 4, 3, 4, 5}; 2,3
//    private static final int[] inputData = {1, 2, 3, 4, 5}; 2,4

    public static void main(String[] args) {
        int[] ints = sortData(inputData);

        for (int i = 0; i < ints.length; i++) {
            System.out.print("| " + ints[i]);
        }
    }

    private static int[] sortData(int[] inputData) {
        if (inputData.length == 1) {
            return inputData;
        }

//        {5, 4, 2, 3, 1};
        int temp = 0;
        for (int i = 0; i < inputData.length; i++) {
            int tempIndex = inputData[inputData[i] - 1];//4,3,1

            if (Math.abs(inputData[tempIndex] - inputData[i]) == inputData[tempIndex]) {
                int value = inputData[tempIndex];
                inputData[tempIndex] = inputData[i];
                inputData[i] = value;
            } else if (Math.abs(tempIndex - temp) == 1) {
                inputData[tempIndex] = inputData[i];
                inputData[temp - 1] = temp;
            } else if (inputData[tempIndex] == 0) {
                inputData[tempIndex] = inputData[i];
                inputData[temp - 1] = temp;
            } else {
                temp = inputData[tempIndex];
                inputData[tempIndex] = inputData[i];
                inputData[i] = 0;
            }
        }
        return inputData;
    }
}
