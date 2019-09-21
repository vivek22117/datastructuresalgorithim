package com.doubledigit.algorithim.chapter1.datastructures.examples;

public class FindNthFibonacciNumber {

    private static final int N = 20;

    public static void main(String[] args) {
        int nthFib = getNthFib(N);
        System.out.println("nthFib = " + nthFib);
    }

    private static int getNthFib(int n) {
        int[] lastTwo = {0,1};
        int counter  = 3;

        while (counter <= n){
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }
}
