package com.google.algo.recursion;

public class SumOfDigits {

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int output = sumOfDigits.findSum(-101);
        System.out.println(output);
    }

    public int findSum(int n) {
        if(n == 0 || n < 0){
            return 0;
        }

        return n%10 + findSum(n/10);
    }
}
