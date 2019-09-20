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
//        boolean result = checkPalindrome.isPalindrome("Mala ya lam");
        boolean floatResult = checkPalindrome.isPalindrome(String.valueOf(121.321f));
//        System.out.println("Given string is Palindrome..? " + result);
        System.out.println("Given float is Palindrome..? " + floatResult);
    }
}
