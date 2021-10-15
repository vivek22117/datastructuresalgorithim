package com.google.algo.recursion;

public class FibonacciRecursive {

    public static void main(String[] args) {
        FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
        int output = fibonacciRecursive.findFibonacci(12);
        System.out.println(output);
    }

    public int findFibonacci(int num) {
        if (num < 0) {
            return -1;
        }

        if( num == 0 || num == 1) {
            return 1;
        }

        return findFibonacci(num -1) + findFibonacci(num -2);
    }
}
