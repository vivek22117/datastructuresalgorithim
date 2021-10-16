package com.google.algo.array;

public class LongestConsecutiveSeq {

    private static int[] input = {4, 200, 34, 1, 10, 300, 2, 33, 3};

    public static void main(String[] args) {
        LongestConsecutiveSeq sequence = new LongestConsecutiveSeq();
        int length = sequence.longestConsecutive(input);
        System.out.println(length);
    }

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
