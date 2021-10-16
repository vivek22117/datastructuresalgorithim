package com.google.algo.other;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        MoveZeros move = new MoveZeros();
        int[] input = {3, 0, 0, 1, 0, 8, 5, 3, 0};
        int[] result = move.moveElements(input);
        System.out.println(Arrays.toString(result));
    }

    public int[] moveElements(int[] input) {
        int index = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i] != 0) {
                input[index++] = input[i];
            }
        }

        for(int i = index; i < input.length; i++) {
            input[i] = 0;
        }

        return input;
    }
}
