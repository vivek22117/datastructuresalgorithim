package com.google.algo.array;


import java.util.HashMap;

/*
Input: "aeabrddldcdxbrtunaqpcxblarc"
SubString: "abc"

Output: "blarc"
 */
public class MinimumWindowSubString {

    private static String source = "aeabrddldcdxbrtunaqpcxblarc";
    private static String target = "abc";

    public static void main(String[] args) {

        MinimumWindowSubString window = new MinimumWindowSubString();
        String result = window.findMinimumWindow(source, target);
        System.out.println(result);

    }

    public String findMinimumWindow(String source, String target) {
        if(source == null || target == null || source.isEmpty() || target.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> targetFrequency = new HashMap<>();
        for(Character ch : target.toCharArray()) {
            targetFrequency.put(ch, targetFrequency.getOrDefault(ch, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int count = targetFrequency.size();

        int minLength = Integer.MAX_VALUE;
        int leftIndex = 0;
        int rightIndex = 0;

        boolean found = false;

        while (j < source.length()) {
             char ch = source.charAt(j);

             if(targetFrequency.containsKey(ch)) {
                 targetFrequency.put(ch, targetFrequency.getOrDefault(ch, 0) - 1);
                 if (targetFrequency.get(ch) == 0) {
                     count -= 1;
                 }
             }
             j++;

             if(count > 0) {
                 continue;
             }

             while (count == 0) {
                 char srcChar = source.charAt(i);
                 if(targetFrequency.containsKey(srcChar)) {
                     targetFrequency.put(srcChar, targetFrequency.get(srcChar) + 1);
                     if(targetFrequency.get(srcChar) > 0) {
                         count += 1;
                     }
                 }
                 i++;
             }

             if((j - i) < minLength) {
                 leftIndex = i;
                 rightIndex = j;
                 minLength = j - i;
                 found = true;
             }

        }

        return !found ? "" : source.substring(leftIndex - 1, rightIndex);

    }
}
