package com.google.algo.matrix;

import java.util.Random;
import java.util.stream.IntStream;

public class CountIsland {

    private static final int N = 8;
    private static int[][] grid = new int[N][N];

    public static void main(String[] args) {
        CountIsland island = new CountIsland();
        int[][] initialMatrix = island.createInitialMatrix(grid);
        island.printGenMatrix(initialMatrix);

        island.numOfIslands(initialMatrix);
    }

    public int numOfIslands(int[][] grid) {

    }

    public int[][] createInitialMatrix(int[][] grid) {
        IntStream.iterate(0, e -> e + 1).limit(grid.length).forEach(e -> {
            int i = new Random().nextInt((N - 1) + 1);
            int j = new Random().nextInt((N - 1) + 1);
            grid[j][i] = 1;
        });

        return grid;
    }

    private void printGenMatrix(int[][] genMatrix) {
        for (int i = 0; i < genMatrix.length; i++) {
            System.out.print("|");
            for (int j = 0; j < genMatrix[i].length; j++) {
                System.out.print(genMatrix[i][j] + "|");
            }
            System.out.println();
        }
    }
}
