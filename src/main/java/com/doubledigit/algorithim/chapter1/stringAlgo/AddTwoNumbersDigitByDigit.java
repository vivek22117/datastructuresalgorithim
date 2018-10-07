package com.doubledigit.algorithim.chapter1.stringAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Vivek Kumar Mishra on 07/10/2018.
 */
public class AddTwoNumbersDigitByDigit {



    public static int[] addNumbers(int[] num1, int[] num2){
        List<Integer> numberSum = new ArrayList<>();
        int lastIndex1 = num1.length -1;
        int lastIndex2 = num2.length -1;

        int total = 0;
        int carry = 0;
        int digit = 0;
        while (lastIndex1 >=0 && lastIndex2 >=0){
            total = num1[lastIndex1] + num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            numberSum.add(0, digit);
            lastIndex1--;
            lastIndex2--;
        }

        while (lastIndex1 >= 0){
            total = num1[lastIndex1] + carry;
            digit = total % 10;
            carry = total / 10;

            numberSum.add(0, digit);
            lastIndex1--;
        }

        while (lastIndex2 >= 0){
            total = num2[lastIndex2] + carry;
            digit = total % 10;
            carry = total / 10;

            numberSum.add(0 , digit);
            lastIndex2--;
        }

        if(carry != 0){
            numberSum.add(0, carry);
        }

        int[] sum = new int[numberSum.size()];
        Stream.iterate(0, e->e+1).limit(numberSum.size()).forEach(e -> {
            sum[e] = numberSum.get(e);
        });

        Stream.iterate(0, e-> e+1).limit(sum.length).forEach(e -> {
            System.out.print(sum[e]);
        });
        return sum;
    }

    public static void main(String[] args) {
        int[] number1 = {4, 5, 7, 0};
        int[] number2 = {2, 4, 5};
        int[] ints = AddTwoNumbersDigitByDigit.addNumbers(number1, number2);
    }
}
