package com.google.algo;

public class SumProductOfArray {

    public static void main(String[] inputs) {
        SumProductOfArray sumProductOfArray = new SumProductOfArray();
        int[] input = {3, 5, 8, 9, 1, 6, 8};
        sumProductOfArray.sumOfArray(input);
    }

    void sumOfArray(int[] array) {
        int sum = 0;
        int product = 1;

        for(int i : array) {
            sum += i;
        }

        for(int i : array) {
            product *= i;
        }

        System.out.println(sum + ", " + product);
    }
}
