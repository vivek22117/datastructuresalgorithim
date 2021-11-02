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

        Integer[] input2 = {4, 78, 12, 98, 88, 76, 44, 23, 78, 99, 99, 98, 88};
        String result2 = twoScores.topTwoScores(input2);
        System.out.println(result2);
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


    public String topTwoScores(Integer[] nums) {
        if(nums.length == 0) {
            return "";
        }

        int topScore = Math.max(nums[0], nums[1]);
        int secondTopScore = Math.min(nums[0], nums[1]);

        if(nums[0] >= nums[1]){
            topScore = nums[0];
            secondTopScore = nums[1];
        } else {
            topScore = nums[1];
            secondTopScore = nums[0];
        }

        for(int i = 2; i < nums.length; i++) {
            if(nums[i] > topScore) {
                secondTopScore = topScore;
                topScore = nums[i];
            } else if(nums[i] > secondTopScore && nums[i] != topScore) {
                secondTopScore = nums[i];
            }
        }

        return topScore + " " + secondTopScore;
    }

}
