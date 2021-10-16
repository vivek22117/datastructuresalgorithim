package com.google.algo.array;

// Given an array find the First, Second best score. Array may contains duplicates


import java.util.Arrays;
import java.util.Collections;

public class FindTopTwoScores {

    public static void main(String[] args) {
        FindTopTwoScores twoScores = new FindTopTwoScores();
        Integer[] input = {4, 78, 12, 98, 88, 76, 44, 23, 78, 99, 99, 98, 88};
        String result = twoScores.scores(input);
        System.out.println(result);
    }

    public String scores(Integer[] input) {
        Arrays.sort(input, Collections.reverseOrder());
        System.out.println(Arrays.toString(input));
        int firstTop = input[0];
        int secondTop = 0;
        for(int i = 1; i < input.length; i++) {
            if(firstTop != input[i]){
                secondTop = input[i];
                break;
            }
        }

        return firstTop + "," + secondTop;
    }

}
