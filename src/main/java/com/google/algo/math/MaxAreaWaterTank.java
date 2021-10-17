package com.google.algo.math;

public class MaxAreaWaterTank {

    private static int[] tank = {1, 8, 6, 2, 5, 4, 8, 3, 1};

    public static void main(String[] args) {
        MaxAreaWaterTank area = new MaxAreaWaterTank();
        int result = area.maxArea(tank);
        System.out.println(result);
    }

    private int maxArea(int[] nums) {
        if(nums.length < 2) {
            return -1;
        }

        int max = 0;
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            max = Math.max(max, Math.min(nums[left], nums[right]) * (right - left));
            if(nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
}
