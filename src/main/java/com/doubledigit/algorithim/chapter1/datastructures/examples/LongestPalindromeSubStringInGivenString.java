package com.doubledigit.algorithim.chapter1.datastructures.examples;


//input: "xhrystulutsnypo" | output: "stulluts"
public class LongestPalindromeSubStringInGivenString {

    private static final String inputData = "xhxrystlunypr";

    public static void main(String[] args) {
        String longestSubStringPalindrome = getLongestSubStringPalindrome(inputData);
        System.out.println("longestSubStringPalindrome = " + longestSubStringPalindrome);
    }

    private static String getLongestSubStringPalindrome(String inputData) {
        int[] currentLongest = {0, 1};
        for (int i = 0; i < inputData.length(); i++) {
            int[] oddPlnd = helperMethod(inputData, i - 1, i + 1);
            int[] evenPlnd = helperMethod(inputData, i - 1, i);

            int[] tempLongest = oddPlnd[1] - oddPlnd[0] > evenPlnd[1] - evenPlnd[0] ? oddPlnd : evenPlnd;
            currentLongest = currentLongest[1] - currentLongest[0] > tempLongest[1] - tempLongest[0] ? currentLongest : tempLongest;
        }

        return inputData.substring(currentLongest[0] , currentLongest[1]);
    }

    private static int[] helperMethod(String inputData, int leftIndx, int rightIndx) {
        while (leftIndx >= 0 && rightIndx < inputData.length()) {
            if (inputData.charAt(leftIndx) != inputData.charAt(rightIndx)) {
                break;
            }
            leftIndx--;
            rightIndx++;
        }
        return new int[]{leftIndx + 1, rightIndx};
    }
}
