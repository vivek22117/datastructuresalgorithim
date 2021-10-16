package com.google.algo.array;

import java.util.Arrays;

public class FindTwoNumSum {

    private static int[] input = {3, 7, 9, 11, 15, 17, 21};

    public static void main(String[] args) {
        FindTwoNumSum twoNumSum = new FindTwoNumSum();
        int[] result = twoNumSum.twoSum(input, 32);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        int a_pointer = 0;
        int b_pointer = nums.length - 1;

        while (a_pointer <= b_pointer) {
            int sum = nums[a_pointer] + nums[b_pointer];

            if(sum == target) {
                return new int[] {a_pointer, b_pointer};
            }

            if(sum > target) {
                b_pointer--;
            }

            if(sum < target) {
                a_pointer++;
            }
        }

        return new int[]{};
    }


}
