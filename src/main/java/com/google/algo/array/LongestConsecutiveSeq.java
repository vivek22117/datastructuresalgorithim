package com.google.algo.array;

import java.util.HashSet;

public class LongestConsecutiveSeq {

    private static int[] input = {4, 200, 34, 1, 0, 300, 2, 33, 3, 101, 102, 109, 111, 110, 103, 104, 107, 106, 108};

    public static void main(String[] args) {
        LongestConsecutiveSeq sequence = new LongestConsecutiveSeq();
        int length = sequence.longestConsecutive(input);
        System.out.println(length);

        int length2 = sequence.longestConsecutiveWithExtraSpace(input);
        System.out.println(length2);
    }

    public int longestConsecutiveWithExtraSpace(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for(int i : nums) {
            numSet.add(i);
        }

        int max_sequence = 0;

        for(int i = 0; i < nums.length; i++) {
            int current_num = nums[i];
            int current_seq_len = 1;

            if(!numSet.contains(current_num - 1)) {
                while(numSet.contains(current_num + 1)) {
                    current_num += 1;
                    current_seq_len += 1;
                }
            }
            max_sequence = Math.max(max_sequence,  current_seq_len);

        }

        return max_sequence;
    }

//  This solution is O(n3)
    public int longestConsecutive(int[] input) {
        int max_sequence = 0;

        for(int i = 0; i < input.length; i++) {
            int current_num = input[i];
            int current_seq_len = 1;

            while (nextNumExist(input, current_num + 1)) {
                current_num += 1;
                current_seq_len += 1;
            }

            max_sequence = Math.max(max_sequence, current_seq_len);
        }

        return max_sequence;
    }

    private boolean nextNumExist(int[] nums, int nextNum) {
        for (int num : nums) {
            if (num == nextNum) {
                return true;
            }
        }
        return false;
    }
}
