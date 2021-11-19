package com.google.algo.array;


/*
Input:
Source Str: "abc"
Target Str: "acbac"

Output: 3  How: "ac" + "b" + "ac"
 */

public class ShortestWaySubString {

    private static String sourceString = "abc";
    private static String targetStrng = "acbac";

    public static void main(String[] args) {

    }


    public int findNumberOfSubSequences(String src, String target) {
        int numOfSequences = 0;

        while (target.length() > 0) {
            int srcIndex = 0;
            int targetIndex = 0;
            while (srcIndex < src.charAt(srcIndex) && targetIndex < target.charAt(targetIndex)) {

            }
        }
    }

}
