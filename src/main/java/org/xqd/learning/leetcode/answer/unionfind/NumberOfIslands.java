package org.xqd.learning.leetcode.answer.unionfind;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        for (int i1 = 0; i1 < grid.length; i1++) {
            for (int i2 = 0; i2 < grid[i1].length; i2++) {
                System.out.println(grid[i1][i2]);
            }
            System.out.println("****************");
        }

        int i = numIslands(grid);

        System.out.println("结果" + i);
        System.out.println("****************");

        for (int i1 = 0; i1 < grid.length; i1++) {
            for (int i2 = 0; i2 < grid[i1].length; i2++) {
                System.out.println(grid[i1][i2]);
            }
            System.out.println("****************");
        }
    }

    /**
     * infecting
     */
    public static int numIslands(char[][] grid) {
        int islandNumber = 0;
        int row = grid.length;
        for (int i = 0; i < row; i++) {

            int column = grid[i].length;
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    islandNumber++;
                    infect(i, j, row, column, grid);
                }
            }
        }

        return islandNumber;
    }

    private static void infect(int i, int j, int row, int column, char[][] grid) {
        if (i >= 0 && j >= 0 && i < row && j < column) {
            if (grid[i][j] == '1') {
                grid[i][j] = '2';
                infect(i - 1, j, row, column, grid);
                infect(i + 1, j, row, column, grid);
                infect(i, j - 1, row, column, grid);
                infect(i, j + 1, row, column, grid);
            }
        }
    }
}
