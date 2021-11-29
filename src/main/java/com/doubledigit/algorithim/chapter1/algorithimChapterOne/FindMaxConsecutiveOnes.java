package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 */
public class FindMaxConsecutiveOnes {

    private static int[] inputData = {0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0};
//    private static int[] inputData = {0, 1, 1};
//    private static int[] inputData = {1, 0, 1};

    public static void main(String[] args) {

        FindMaxConsecutiveOnes ones = new FindMaxConsecutiveOnes();
        String maxConsecutiveOnesIndex = ones.findMaxConsecutiveOnesIndex(inputData);
        System.out.println(maxConsecutiveOnesIndex);

        int N = inputData.length;
        int i = 0;
        int max_length = Integer.MIN_VALUE;

        for (int e = 0; e < N; e++) {
            if (inputData[e] == 1) {
                int r = e + 1;
                int count = 1;
                while (r < N) {
                    if (inputData[r] != 1) break;
                    count = count + 1;
                    r++;
                }
                max_length = Math.max(max_length, count);
                e = r;
            }
        }
        System.out.println("Maximum number of One's are: " + max_length);
    }

    public String findMaxConsecutiveOnesIndex(int[] nums) {
        int N = nums.length;
        int maxLength = Integer.MIN_VALUE;
        String indexes = "";

        for(int i = 0; i < N; i++) {
            if(nums[i] == 1) {
                int r = i + 1;
                int count = 1;

                while (r < N) {
                    if(nums[r] != 1) break;
                    count = count + 1;
                    r++;
                }

                if(maxLength < count) {
                    maxLength = count;
                    indexes = i + " to " + (r - 1);
                }
                i = r;
            }
        }
        System.out.println(maxLength);
        return indexes;
    }
}
