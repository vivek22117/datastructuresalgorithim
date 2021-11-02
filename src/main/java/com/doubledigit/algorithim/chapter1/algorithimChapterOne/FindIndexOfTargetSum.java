package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import static java.lang.Double.compare;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 *
 * Below algo finds the indexes of target sum.
 */
public class FindIndexOfTargetSum {

    private static int[] inputData = {3,6,8,7,15,9,11,0};
    private static int target  = 12;

    public static void main(String[] args) {
        int N = inputData.length;
        int[][] copyOf2DArray = createCopyOf2DArray(inputData);
        Arrays.sort(copyOf2DArray, Comparator.comparingInt(new ToIntFunction<int[]>() {
            @Override
            public int applyAsInt(int[] o) {
                return o[0];
            }
        }));

        int[] result = new int[2];
        int i = 0;
        int j = N-1;
        while (i < j){
            if(copyOf2DArray[i][0] + copyOf2DArray[j][0] == target){
                result[0] = copyOf2DArray[i][1];
                result[1] = copyOf2DArray[j][1];
            }
            if(copyOf2DArray[i][0] + copyOf2DArray[j][0] > target){
                j--;
            } else {
                i++;
            }
        }

        System.out.println("Indexes for target sum are: " + result[0] + " == " + result[1]);
    }

    private static int[][] createCopyOf2DArray(int[] inputData) {
        int[][] copy = new int[inputData.length][2];
        IntStream.range(0, inputData.length).forEach(e -> {
            copy[e][0] = inputData[e];
            copy[e][1] = e;
        });
     return copy;
    }
}