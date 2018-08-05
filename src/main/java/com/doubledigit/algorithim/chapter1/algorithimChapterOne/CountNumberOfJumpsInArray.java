package com.doubledigit.algorithim.chapter1.algorithimChapterOne;

/**
 * Created by Vivek Kumar Mishra on 04/08/2018.
 *
 * Below code counts the number of jumps happens in an array......
 * Example...[2,2,-1,1]...will result in 3 jumps.....
 */
public class CountNumberOfJumpsInArray {

    public static void main(String[] args) {

        int[] data = {2,2,-1,3,2,3,1,4};
        int jumps = countNoOfJumps(data);
        System.out.println("No of jumps done on provide data is: " + jumps);
    }

    private static int countNoOfJumps(int[] data) {
        int n = data.length;
        int i = 0;
        int count = 0;
        while (i < n){
            int j = data[i];
            i = j + i;
            if(i<0 || i> n-1) break;
            count++;
        }
        return count;
    }
}
