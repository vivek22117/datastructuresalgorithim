package com.google.algo.array;


/*
Input: [10, 3, 5, 8, 6, 12, 20, 15, 31],   Target:31
Output: [5,8,6,12]
Explanation: Subarray with sum equal to Target
 */
public class SubArrayTargetSum {

    private static int[] input = {10, 3, 5, 0, 6, 12, 20, 15, 31};

    public static void main(String[] args) {
        SubArrayTargetSum sum = new SubArrayTargetSum();
        String result = sum.getSubArray(input, 31);
        System.out.println(result);

    }

    public String getSubArray(int[] nums, int target) {
        if(nums.length == 0) {
            return "";
        }

        int sum = nums[0];
        int startIndex = 0;
        int endIndex = 1;

        while (endIndex < nums.length || startIndex < nums.length) {
            if(sum > target && startIndex < nums.length) {
                sum -= nums[startIndex];
                startIndex++;
            } else  if(sum < target) {
                sum += nums[endIndex];
                endIndex++;
            } else {
                return "Index " + startIndex + " to " + (endIndex -1);
            }
        }

        return "";
    }
}
