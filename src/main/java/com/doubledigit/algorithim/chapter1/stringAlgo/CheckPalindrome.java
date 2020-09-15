package com.doubledigit.algorithim.chapter1.stringAlgo;

/**
 * Created by Vivek Kumar Mishra on 29/09/2018.
 */
public class CheckPalindrome {


    public boolean isPalindrome(String inputString){
        inputString = inputString.toLowerCase();

        int index = 0;
        int lastIndex = inputString.length() -1;
        while (index < lastIndex){
            char forwardChar = inputString.charAt(index);
            char reverseChar = inputString.charAt(lastIndex);

            while (forwardChar == '.'){
                index++;
                forwardChar = inputString.charAt(index);
            }
            while (reverseChar == '.'){
                lastIndex--;
                reverseChar = inputString.charAt(lastIndex);
            }
            if(forwardChar != reverseChar){
                return false;
            }
            index++;
            lastIndex--;
        }
        return true;
    }


    public static void main(String[] args) {
        CheckPalindrome checkPalindrome = new CheckPalindrome();
        boolean result = checkPalindrome.isPalindrome("Malayalam");
        boolean floatResult = checkPalindrome.isDigitPalindrome(String.valueOf(301.003f));
        System.out.println("Given string is Palindrome..? " + result);
        System.out.println("Given float is Palindrome..? " + floatResult);
    }

    private boolean isDigitPalindrome(String valueOf) {
        if(valueOf.length() == 0) {
            return false;
        }

        int startIndx = 0;
        int lastIndx = valueOf.length() - 1;

        while (startIndx < lastIndx) {
            char forwardChar = valueOf.charAt(startIndx);
            char backwardChar = valueOf.charAt(lastIndx);

            while (forwardChar == '.') {
                startIndx++;
                forwardChar = valueOf.charAt(startIndx);
            }

            while (backwardChar == '.') {
                lastIndx--;
                backwardChar = valueOf.charAt(lastIndx);
            }

            if(forwardChar != backwardChar) {
                return false;
            }

            startIndx++;
            lastIndx--;
        }

        return true;
    }


}
