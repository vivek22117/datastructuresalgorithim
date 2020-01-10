package com.doubledigit.algorithim.chapter1.datastructures.examples;

import java.util.stream.IntStream;

public class RunLengthEncoding {
    private static String inputData = "aacccccdddeffffrrrrt";


    public static void main(String[] args) {
        char[] chars = inputData.toCharArray();
        String resutlEncoded = encodeInputData(inputData);
        System.out.println("resutlEncoded = " + resutlEncoded);

        String resultDecoded = decodeResultEncoded(resutlEncoded);
        System.out.println("resultDecoded = " + resultDecoded);
    }

    private static String decodeResultEncoded(String resutlEncoded) {
        if(resutlEncoded.length() == 0){
            return null;
        }

        int startIndx = 0;
        int endIndx = 1;
        StringBuilder sb = new StringBuilder();
        while (endIndx < resutlEncoded.length()){
            if(Character.isDigit(resutlEncoded.charAt(endIndx))){
                endIndx += 1;
            }

            String substring = resutlEncoded.substring(startIndx, endIndx);
            Integer value = Integer.valueOf(substring);
            char ch = resutlEncoded.charAt(endIndx);
            IntStream.iterate(0, e -> e + 1).limit(value).forEach(e -> {
                sb.append(ch);
            });

            startIndx = endIndx + 1;
            endIndx = startIndx + 1;
        }
        return sb.toString();
    }

    private static String encodeInputData(String inputData) {

        if(inputData.length() == 0){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        int startIndx = 0;
        while (startIndx < inputData.length()){
            char ch = inputData.charAt(startIndx);

            int tempIndx = startIndx;
            int count = 0;
            while (tempIndx < inputData.length() && inputData.charAt(tempIndx) == ch){
                tempIndx += 1;
                count += 1;
            }

            sb.append(count);
            sb.append(ch);
            startIndx = tempIndx;
        }
        return sb.toString();
    }


}
