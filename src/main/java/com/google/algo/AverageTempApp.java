package com.google.algo;

import java.util.*;

public class AverageTempApp {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("How many day's temperature?");
        int numDays = console.nextInt();
        int[] temps = new int[numDays];

        int sum = 0;
        for(int i = 0; i<numDays; i++) {
            System.out.print("Day " + (i + 1) + "'s high temperature: ");
            temps[i] = console.nextInt();
            sum += temps[i];
        }

        double averageTemp = sum / numDays;
        int aboveCount = 0;
        for(int value : temps) {
            if(value > averageTemp) {
                aboveCount++;
            }
        }
        System.out.println("Average temperature: " + averageTemp);
        System.out.println("Total day's above average temperature: " + aboveCount);
    }


}
