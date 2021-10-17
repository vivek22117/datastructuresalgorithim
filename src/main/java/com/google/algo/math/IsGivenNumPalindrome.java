package com.google.algo.math;

public class IsGivenNumPalindrome {

    private static int N = 1221;

    public static void main(String[] args) {
        IsGivenNumPalindrome palindrome = new IsGivenNumPalindrome();
        boolean result = palindrome.isPalindrome(N);

        System.out.println(result);
    }

    public boolean isPalindrome(int num) {
        if(num < 0) {
            return false;
        }

        int reverse = 0;
        int original = num;
        while(num != 0) {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }

        return reverse == original;
    }
}
