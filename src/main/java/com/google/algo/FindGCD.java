package com.google.algo;

public class FindGCD {

    public static void main(String[] args) {
        FindGCD findGCD = new FindGCD();
        int output = findGCD.getGCD(8, 18);

        System.out.println(output);
    }

    public int getGCD(int a, int b) {
        if(a < 0 || b < 0) {
            return 0;
        }

        if(b == 0) {
            return a;
        }

        return getGCD(b, a%b);
    }
}
