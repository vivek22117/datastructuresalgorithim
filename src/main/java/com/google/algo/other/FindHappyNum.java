package com.google.algo.other;


import java.util.HashSet;

// Input : 19
// Output: True
// Explanation:
//  1 x 1 + 9 x 9 = 82
//  8 x 8 + 2 x 2 = 68
//  6 x 6 + 8 x 8 = 100
//  1 x 1 + 0 x 0 + 0 x 0 = 1
public class FindHappyNum {

    public static void main(String[] args) {
        FindHappyNum num = new FindHappyNum();
        int input = 199;
        boolean result = num.findNum(input);
        System.out.println(result);
    }

    public boolean findNum(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while(n != 1){
            int current = n;
            int sum = 0;
            while (current != 0) {
                sum += (current % 10) * (current % 10);
                current = current / 10;
            }

            if(seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            n = sum;
        }

        return true;
    }
}
