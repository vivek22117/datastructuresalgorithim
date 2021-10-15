package com.google.algo.array;

import java.util.*;

public class SumOfDiagonal {

    public static void main(String[] args) {
        SumOfDiagonal diagonalSum = new SumOfDiagonal();
        int[][] input = {{2, 5, 7}, {0, 7, 1}, {4, 6, 8}};
        int result = diagonalSum.sumDiagonal(input);
        System.out.println(result);
    }

    public int sumDiagonal(int[][] input) {
        int sum = 0;

        for(int i = 0; i < input.length; i++) {
            sum += input[i][i];
        }

        return sum;
    }
}
