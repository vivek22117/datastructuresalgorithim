package com.google.algo.array;

public class IsTwoArrayPermutation {

    public static void main(String[] args) {
        IsTwoArrayPermutation isPermutation = new IsTwoArrayPermutation();
        int[] a1 = {2, 5, 7, 9};
        int[] a2 = {5, 9, 2 ,7};
        boolean result = isPermutation.isPermutation(a1, a2);
        System.out.println(result);
    }

    public boolean isPermutation(int[] array1, int[] array2) {
        if(array1.length != array2.length) {
            return false;
        }

        int sum1 = 0;
        int sum2 = 0;
        int prod1 = 1;
        int prod2 = 1;

        for(int i = 0; i < array1.length; i++) {
            sum1 += array1[i];
            sum2 += array2[i];

            prod1 *= array1[i];
            prod2 *= array2[i];
        }

        if(sum1 == sum2 && prod1 == prod2) {
            return true;
        }
        return false;
    }
}
