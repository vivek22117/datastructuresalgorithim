package com.google.algo.array;


/*
Input:
Source Str: "abc"
Target Str: "acbac"

Output: 3  How: "ac" + "b" + "ac"
 */

import javax.sound.midi.Soundbank;

public class ShortestWaySubString {

    private static String sourceString = "abc";
    private static String targetString = "acb";

    public static void main(String[] args) {
        ShortestWaySubString subString = new ShortestWaySubString();
        int numberOfSubSequences = subString.findNumberOfSubSequences(sourceString, targetString);
        System.out.println(numberOfSubSequences);
    }


    public int findNumberOfSubSequences(String src, String target) {
        int numOfSequences = 0;

        while (target.length() > 0) {
            int srcIndex = 0;
            int targetIndex = 0;
            StringBuilder builder = new StringBuilder();
            while (srcIndex < src.length() && targetIndex < target.length()) {
                if(src.charAt(srcIndex) == target.charAt(targetIndex)) {
                    builder.append(target.charAt(targetIndex));
                    targetIndex++;
                }
                srcIndex++;
            }

            if(builder.length() == 0) {
                return -1;
            }
            numOfSequences++;
            target = target.substring(builder.length());
        }

        return numOfSequences;
    }

}
