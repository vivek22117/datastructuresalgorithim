package com.google.algo;

public class DecimalToBinary {

    public static void main(String[] args) {
        DecimalToBinary decimalToBinary = new DecimalToBinary();
        int output = decimalToBinary.convertDecToBin(115);
        System.out.println(output);
    }


    public int convertDecToBin(int num) {
        if(num == 0){
            return 0;
        }

        return num%2 + 10*convertDecToBin(num/2);
    }
}
