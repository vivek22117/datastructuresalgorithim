package com.doubledigit.algorithim.chapter1.stringAlgo;

/**
 * Created on 23/09/2018.
 *
 * Given method isSubstring() which checks if one word is substring of another. Given two String s1, s2 write code to check
 * if s2 is a rotation of s1 using only one call to isSubstring()
 *
 * eg: "vivekMishra" is a rotation of "ekMishraviv"
 */
public class CheckRotation {

    public boolean isSubstring(String s1, String s2){
        return s1.contains(s2);
    }

    public boolean isRotation(String a1, String a2){
        //Implement here.......

        return false;
    }


    public static void main(String[] args) {
      CheckRotation checkRotation = new CheckRotation();
        boolean isRotation = checkRotation.isRotation("ohnDeereTCIJ", "JohnDeereTCI");

        System.out.println(isRotation);
    }
}
