package com.doubledigit.algorithim.chapter1.stringAlgo;

/**
 * Created by Vivek Kumar Mishra on 14/10/2018.
 */
public class CheckPalindromeInPermutation {

private static String input = "Tact Coa";

    public static void main(String[] args) {
        boolean palindrome = CheckPalindromeInPermutation.isPalindrome(input);
        System.out.println("Result is.." + palindrome);
    }

    public static boolean isPalindrome(String inputString){
        int countOdd = 0;
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a')];
        System.out.println(table.length);

        for(char c : inputString.toCharArray()){
            int x = getCharNumber(c);
            if(x != -1){
                table[x]++;
                System.out.println("Value at index ..." + table[x]);
                if(table[x] % 2 == 1){
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }

    private static int getCharNumber(char c) {
        int value = Character.getNumericValue(c);
        System.out.println("Value is.." + value);
        int z = Character.getNumericValue('z');
        int a = Character.getNumericValue('a');
        if(a <= value && value <=z){
            System.out.println("operation output is.." + (value - a));
            return value - a;
        }
        return -1;
    }
}
