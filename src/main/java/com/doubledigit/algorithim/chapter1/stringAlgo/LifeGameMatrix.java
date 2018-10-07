package com.doubledigit.algorithim.chapter1.stringAlgo;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Vivek Kumar Mishra on 29/09/2018.
 */
public class LifeGameMatrix {

    private static int N = 8;
    private static int[][] currentGen = new int[N][N];


    public static void main(String[] args) {
        LifeGameMatrix lifeGameMatrix = new LifeGameMatrix();

        printGenMatrix(currentGen);
        int[][] updatedGenMatrix = LifeGameMatrix.updatedCurrentGen(currentGen);
        System.out.println("After Updation...");
        printGenMatrix(updatedGenMatrix);
        int[][] nextGenMatrix = getNextGenMatrix(updatedGenMatrix);
        System.out.println("Getting next Gen Matrix....");
        printGenMatrix(nextGenMatrix);
    }




    public LifeGameMatrix() {
        IntStream.iterate(0, e -> e + 1).limit(N).forEach(e -> {
            IntStream.iterate(0, i -> i + 1).limit(N).forEach(i -> {
                currentGen[e][i] = 0;
            });
        });
    }

    public static int[][] updatedCurrentGen(int[][] genMatrix){
        IntStream.iterate(0, e-> e+1).limit(20).forEach(e -> {
            int i = new Random().nextInt(((N - 1) - 0) + 1);
            int j = new Random().nextInt(((N - 1) - 0) + 1);
            genMatrix[j][i] = 1;
        });
        return genMatrix;
    }

    public static int[][] getNextGenMatrix(int[][] previousMatrix){
        int[][] nextGen = new int[N][N];
        IntStream.iterate(0, e -> e + 1).limit(N).forEach(e -> {
            IntStream.iterate(0, i -> i + 1).limit(N).forEach(i -> {
                nextGen[e][i] = getCellState(e, i, previousMatrix);
            });
        });
        return nextGen;
    }

    private static void printGenMatrix(int[][] genMatrix) {
        for (int i = 0; i < genMatrix.length; i++) {
            for (int j = 0; j < genMatrix[i].length; j++) {
                System.out.print(genMatrix[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static int getCellState(int row, int col, int[][] current){
        int liveCount = 0;
        int lastIndex = N - 1;

        if(row > 0 && col > 0){
            liveCount += current[row -1][col-1];
        }

        if(row > 0){
            liveCount += current[row-1][col];
            if(col < lastIndex){
                liveCount += current[row-1][col+1];
            }
        }

        if(col < lastIndex){
            liveCount += current[row][col+1];
        }

        if(col > 0){
            liveCount += current[row][col-1];
            if(row < lastIndex){
                liveCount += current[row+1][col-1];
            }
        }

        if(row < lastIndex){
            liveCount += current[row+1][col];
        }

        if(row < lastIndex && col < lastIndex){
            liveCount += current[row+1][col+1];
        }

        return  liveCount == 2 ? 1 : 0;

    }
}
