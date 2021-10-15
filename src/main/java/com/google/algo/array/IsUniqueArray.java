package com.google.algo.array;

public class IsUniqueArray {

    public static void main(String[] args) {
        IsUniqueArray isUnique = new IsUniqueArray();
        int[] input = {2, 5, 8, 9, 11, 23, 67, 88};
        boolean result = isUnique.isUnique(input);
        System.out.println(result);
    }

    public boolean isUnique(int[] input) {
        for(int i = 0; i < input.length; i++) {
            for(int j = i + 1; j < input.length; j++) {
                if(input[i] == input[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
