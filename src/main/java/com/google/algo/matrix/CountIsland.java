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

        int count = island.numOfIslands(initialMatrix);
        System.out.println(count);
    }

    public int numOfIslands(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    count += 1;
                    processGrid(grid, i, j);
                }
            }
        }
        System.out.println("==========================");
        printGenMatrix(grid);
        return count;
    }

    private void processGrid(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        processGrid(grid, i -1, j);
        processGrid(grid, i + 1, j);
        processGrid(grid, i, j - 1);
        processGrid(grid, i, j + 1);
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
        for (int[] matrix : genMatrix) {
            System.out.print("|");
            for (int i : matrix) {
                System.out.print(i + "|");
            }
            System.out.println();
        }
    }
}
