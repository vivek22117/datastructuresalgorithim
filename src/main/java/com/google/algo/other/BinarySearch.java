package com.google.algo.other;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] input = {14, 8, 11, 19, 21, 26, 4, 38, 44};

        BinarySearch search = new BinarySearch();
        int result = search.findElement(input, 19);
        System.out.println(result);
    }

    public int findElement(int[] nums, int target) {
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length -1;

        while(min <= max) {
            int mid = min + (max - min)/2;
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                max = mid -1;
            } else {
                min = mid + 1;
            }
        }

        return -1;
    }
}
