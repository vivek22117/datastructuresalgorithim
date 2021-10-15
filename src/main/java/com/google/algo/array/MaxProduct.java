package com.google.algo.array;

import java.util.Arrays;

public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct  maxProduct = new MaxProduct();
        int[] input = {20, 33, 67, 100, 200};
        int[] result = maxProduct.findMaxProduct(input);
        System.out.println(Arrays.toString(result));
    }

    public int[] findMaxProduct(int[] input) {
        int maxProduct = 0;
        int[] pairs = new int[2];
        for(int i = 0; i < input.length; i++) {
            for(int j = i + 1; j < input.length; j++) {
                if(input[i] * input[j] > maxProduct) {
                    maxProduct = input[i] * input[j];
                    pairs[0] = input[i];
                    pairs[1] = input[j];
                }
            }
        }
        return pairs;
    }
}
