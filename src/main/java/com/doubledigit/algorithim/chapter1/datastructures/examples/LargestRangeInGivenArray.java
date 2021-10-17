package com.doubledigit.algorithim.chapter1.datastructures.examples;

//input: [8,9,2,11,0,7,4,3,14,18,19,1] | output:[0,4]
public class LargestRangeInGivenArray {

    private static int[] input = {8, 9, 2, 11, 10, 7, 4, 3, 14, 12, 19, 1};

    public static void main(String[] args) {
        LargestRangeInGivenArray sequence = new LargestRangeInGivenArray();
        int result = sequence.longestSeq(input);

        System.out.println(result);
    }

    private int longestSeq(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int max_sequence = 0;

        for (int i = 0; i < nums.length; i++) {
            int current_num = nums[i];
            int current_seq = 1;

            while(isNumExist(nums, current_num + 1)) {
                current_num += 1;
                current_seq += 1;
            }

            max_sequence = Math.max(max_sequence, current_seq);
        }

        return max_sequence;
    }

    private boolean isNumExist(int[] nums, int num) {
        for(int value : nums) {
            if(num == value) {
                return true;
            }
        }
        return false;
    }

}
