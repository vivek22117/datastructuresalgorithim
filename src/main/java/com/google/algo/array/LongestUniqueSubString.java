package com.google.algo.array;


import java.util.HashSet;

/*
Input: "kwwxeylw"

Output: 5
 */
public class LongestUniqueSubString {

    private static String input = "kwwxeylw";

    public static void main(String[] args) {
        LongestUniqueSubString subString = new LongestUniqueSubString();
        int longestSubString = subString.findLongestSubString(input);

        System.out.println(longestSubString);
    }

    public int findLongestSubString(String input) {
        if (input == null || input.isEmpty()) {
            return -1;
        }

        int i = 0;
        int j = 0;

        int longestSubString = Integer.MIN_VALUE;

        HashSet<Character> uniqueChars = new HashSet<>();
        while (i < input.length()) {
            char ch = input.charAt(i);

            while (uniqueChars.contains(ch)) {
                uniqueChars.remove(input.charAt(j));
                j++;
            }

            uniqueChars.add(ch);
            longestSubString = Math.max(longestSubString, i - j + 1);
            i++;
        }

        return longestSubString;
    }
}
