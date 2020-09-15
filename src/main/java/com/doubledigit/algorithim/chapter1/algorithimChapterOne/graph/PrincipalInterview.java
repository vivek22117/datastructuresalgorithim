package com.doubledigit.algorithim.chapter1.algorithimChapterOne.graph;

public class PrincipalInterview {

    private static float inputdata = 12.321f;

    public static void main(String[] args) {
        boolean result = checkGivenFloatNumberIsPalindrome(inputdata);
        System.out.println("result = " + result);
    }

    private static boolean checkGivenFloatNumberIsPalindrome(float inputdata) {
        String convertValue = String.valueOf(inputdata);

        int index = 0;
        int lastIndex = convertValue.length() - 1;
        while (index <= lastIndex){
            char forwardChar = convertValue.charAt(index);
            char backwardChar = convertValue.charAt(lastIndex);

            while (forwardChar == '.'){
                index++;
                forwardChar = convertValue.charAt(index);
            }
            while (backwardChar == '.'){
                lastIndex--;
                backwardChar = convertValue.charAt(lastIndex);
            }
            if(forwardChar != backwardChar){
                return false;
            }
            index++;
            lastIndex--;
        }
        return true;
    }

}
