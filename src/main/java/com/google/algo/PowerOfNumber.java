package com.google.algo;

public class PowerOfNumber {

    public static void main(String[] args) {
        PowerOfNumber powerOfNumber = new PowerOfNumber();
        int output = powerOfNumber.getPowerOfNum(2, 3);
        System.out.println(output);
    }

    public int getPowerOfNum(int base, int exp) {
        if(exp < 0) {
            return -1;
        }

        if(exp == 0) {
            return 1;
        }

        return base * getPowerOfNum(base, exp -1);
    }
}
