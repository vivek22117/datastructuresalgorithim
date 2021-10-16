package com.google.algo.array;

import java.util.HashSet;

public class FindNonRepeatingNum {

    public static void main(String[] args) {
        FindNonRepeatingNum num = new FindNonRepeatingNum();
        int[] data = {3, 5, 3, 7, 4, 8, 1, 7, 1, 0};
        int result = num.findNum(data);
        System.out.println(result);
    }

    public int findNum(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums) {
            if(set.contains(val)){
                set.remove(val);
            } else {
                set.add(val);
            }
        }

        for(int i : set){
            return i;
        }

        return -1;
    }
}
