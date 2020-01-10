package com.doubledigit.algorithim.chapter1.datastructures.examples;


import java.util.HashMap;
import java.util.Map;

//input: "donebyone climate"  | output: "byoneclimat"
public class LongestUniqueCharSubstring {

    private static final String inputData = "donebyone climate";

    public static void main(String[] args) {

        String result = getLongestUniqueCharSubstring(inputData);

        System.out.println("result = " + result);
    }

    private static String getLongestUniqueCharSubstring(String inputData) {
        Map<Character, Integer> charMap = new HashMap<>();

        int[] longestStringIndx = new int[]{0, 1};
        int startIndx = 0;

        for (int i = 0; i < inputData.length(); i++) {
            char ch = inputData.charAt(i);

            if (charMap.containsKey(ch)) {
                startIndx = Math.max(startIndx, charMap.get(ch) + 1);
            }

            if ((longestStringIndx[1] - longestStringIndx[0]) < ((i + 1) - startIndx)) {
                longestStringIndx = new int[]{startIndx, i + 1};
            }
            charMap.put(ch, i);
        }
        String result = inputData.substring(longestStringIndx[0], longestStringIndx[1]);
        return result;
    }
}
