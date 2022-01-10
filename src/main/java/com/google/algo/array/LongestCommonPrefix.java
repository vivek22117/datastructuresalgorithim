package com.google.algo.array;

public class LongestCommonPrefix {

    private static String[] input = {"leot", "leetcode", "leets", "leeds"};

    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String result = prefix.commonPrefix(input);
        System.out.println(result);
    }

    private String commonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }

        for(int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(i == strs[j].length() || ch != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    private String findCommonPrefix(String[] words) {
        if(words.length == 0) {
            return "";
        }

        for(int i = 0; i < words[0].length(); i++){
            char ch = words[0].charAt(i);
            for(int j = 1; j < words.length; j++) {
                if(i == words[j].length() || ch != words[j].charAt(i)) {
                    return words[0].substring(0, i);
                }
            }
        }

        return words[0];
    }
}
