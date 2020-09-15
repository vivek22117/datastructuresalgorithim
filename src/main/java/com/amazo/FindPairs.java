package com.amazo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class FindPairs {

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for(int i = 0; i < N; i++){
            solve(Integer.parseInt(br.readLine()));
        }
    }

    //1 2 3 4 5 6 7 8 9 10 11 12
    // 1 2 4 4
    // 3 2 4 4
    // 2 3 4 4
    private static void solve(Integer readLine) {
        System.out.println(readLine);

        int input[] = new int[readLine];
        Scanner sc =  new Scanner(System.in);
        for(int i = 0; i<readLine; i++) {
            input[i] = sc.nextInt();
            System.out.print(input[i] + " ");
        }
        Arrays.sort(input);
        System.out.println();

        int pairs = 0;
        int notPairs = 0;
        int mid = input.length / 2;
        int indexForA = 0;
        int indexForB = mid;
        while (indexForA < mid && indexForB < input.length) {
            if(input[indexForB] >= input[indexForA] * 2) {
                pairs += 1;
                indexForA++;
            } else {
                notPairs += 1;
            }
            indexForB++;
            if(indexForA == mid && indexForB == input.length) {
                break;
            }
            if(indexForB == input.length) {
                notPairs += 1;
                break;
            }
            if(indexForA == mid && indexForB == input.length -1){
                notPairs += 1;
            }
        }
        System.out.println(pairs + " " + notPairs);
    }
}
