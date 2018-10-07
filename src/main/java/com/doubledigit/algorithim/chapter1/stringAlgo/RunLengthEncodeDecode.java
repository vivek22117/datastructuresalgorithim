package com.doubledigit.algorithim.chapter1.stringAlgo;

import java.util.stream.Stream;

/**
 * Created by Vivek Kumar Mishra on 29/09/2018.
 */
public class RunLengthEncodeDecode {


    public static String encodeString(String inputString) {
        if (inputString == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int currentIndex = 0;
        while (currentIndex < inputString.length()) {
            char currentChar = inputString.charAt(currentIndex);

            int count = 0;
            int tempIndex = currentIndex;
            while (tempIndex < inputString.length() && currentChar == inputString.charAt(tempIndex)) {
                tempIndex++;
                count++;
            }

            sb.append(count);
            sb.append(currentChar);
            currentIndex = tempIndex;
        }

        return sb.toString();
    }

    public static String decodeString(String encodedString) {
        if (encodedString == null) {
            return null;
        }

        int numStartIndex = 0;
        int numEndIndex = 1;
        StringBuilder sb = new StringBuilder();
        while (numEndIndex < encodedString.length()) {
            while (Character.isDigit(encodedString.charAt(numEndIndex))) {
                numEndIndex++;
            }
            int charIndex = numEndIndex;
            String substring = encodedString.substring(numStartIndex, numEndIndex);
            Integer num = Integer.valueOf(substring);
            Stream.iterate(0, e -> e + 1).limit(num).forEach(e -> {
                sb.append(encodedString.charAt(charIndex));
            });
            numStartIndex = charIndex + 1;
            numEndIndex = numStartIndex + 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String encodedString = RunLengthEncodeDecode.encodeString("aabvvvvdnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        System.out.println(encodedString);

        String decodedString = RunLengthEncodeDecode.decodeString(encodedString);

        System.out.println(decodedString);
    }

}
