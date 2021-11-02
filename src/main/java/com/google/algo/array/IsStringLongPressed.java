package com.google.algo.array;

public class IsStringLongPressed {

    private static String input = "Vivek";
    private static String longPressed = "Viiieeekkkkk";

    public static void main(String[] args) {
        IsStringLongPressed pressed = new IsStringLongPressed();
        boolean result = pressed.isLongPressedString(input, longPressed);
        System.out.println(result);
    }

    public boolean isLongPressedString(String input, String longPressedStr) {
        if(input == null || input.length() == 0) {
            return false;
        }
        int m = input.length();
        int n = longPressedStr.length();

        if(longPressedStr.length() < input.length() || input.charAt(m - 1) != longPressedStr.charAt(n -1)) {
            return false;
        }

        int i = 0;
        int j = 0;

        while (i < m && j < n) {
            char ch1 = input.charAt(i);
            char ch2 = longPressedStr.charAt(j);

            if(ch1 != ch2) {
                return false;
            }

            while (i < input.length() && ch1 == input.charAt(i)){
                i++;
            }

            while (j < longPressedStr.length() && ch2 == longPressedStr.charAt(j)) {
                j++;
            }

        }
        return true;
    }
}
