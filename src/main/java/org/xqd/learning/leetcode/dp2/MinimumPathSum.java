package org.xqd.learning.leetcode.dp2;


/**
 * 64. Minimum Path Sum
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] array = new int[row + 1][column + 1];
        for (int i = 0; i < row + 1; i++) {
            array[i][column] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < column + 1; i++) {
            array[row][i] = Integer.MAX_VALUE;
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                if (i == row - 1 && j == column - 1) {
                    array[i][j] = grid[i][j];
                } else {
                    array[i][j] = grid[i][j] + Math.min(array[i + 1][j], array[i][j + 1]);
                }
            }
        }

        return array[0][0];
    }


    public int minPathSum1(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int r = Integer.MAX_VALUE;
        return f(0, 0, row, column, grid, r);
    }

    private int f(int i, int j, int row, int column, int[][] grid, int r) {
        if (i > row - 1 || j > column - 1) {
            return 0;
        }

        if (i == row - 1 && j == column - 1) {
            return -1;
        }

        int p1 = f(i, j + 1, row, column, grid, r) + grid[i][j];
        int p2 = f(i + 1, j, row, column, grid, r) + grid[i + 1][j];

//        if (p2 == -1) {
//            if (p1 + p2 < r) {
//                r = p1 + p2;
//            }
//        }

        return Math.min(p1, p2);
    }
}
