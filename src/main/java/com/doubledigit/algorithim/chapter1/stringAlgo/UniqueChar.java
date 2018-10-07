package com.doubledigit.algorithim.chapter1.stringAlgo;

/**
 * Created on 23/09/2018.
 *
 * Create an algorithim to determine if a string has all unique characters.
 */
public class UniqueChar {

    public boolean isUniqueCharacters(String str){
        if(str.length() > 128) return false;

        boolean[] isUnique = new boolean[128];
        for(int i =0; i< str.length(); i++){
            int val = str.charAt(i);
            if(isUnique[val]){
                return false;
            }
            isUnique[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueChar uniqueChar = new UniqueChar();

        boolean result = uniqueChar.isUniqueCharacters("Mishra");
        System.out.println(result);
    }
}
