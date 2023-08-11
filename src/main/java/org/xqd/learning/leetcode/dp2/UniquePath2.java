package org.xqd.learning.leetcode.dp2;

public class UniquePath2 {

    /**
     * 基于上一个dp进行简化
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] arr = new int[m + 1][n + 1];
        arr[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                arr[i][j] = (obstacleGrid[i][j] == 1) ? 0 : arr[i][j + 1] + arr[i + 1][j];
            }
        }

        return arr[0][0];
    }

    /**
     * 基于递归进行改造
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 1 && n == 1) {
            if (obstacleGrid[m-1][n-1] == 1) {
                return 0;
            } else {
                return 1;
            }
        }

        if (obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] arr = new int[m][n];
        arr[m - 1][n - 1] = 1;

        if (m >= 2) {
            for (int i = m - 2; i >= 0; i--) {
                if (obstacleGrid[i][n - 1] == 1) {
                    arr[i][n - 1] = 0;
                } else {
                    arr[i][n - 1] = arr[i + 1][n - 1];
                }
            }
        }

        if (n >= 2) {
            for (int i = n - 2; i >= 0; i--) {
                if (obstacleGrid[m - 1][i] == 1) {
                    arr[m - 1][i] = 0;
                } else {
                    arr[m - 1][i] = arr[m - 1][i + 1];
                }
            }
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
                }
            }
        }

        return arr[0][0];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return f(0, 0, m, n, obstacleGrid);
    }

    private int f(int r, int c, int m, int n, int[][] obstacleGrid) {
        if (r > m - 1 || c > n - 1) {
            return 0;
        }

        if (obstacleGrid[r][c] == 1) {
            return 0;
        }

        if (r == m - 1 && c == n - 1) {
            return 1;
        }

        int p1 = f(r, c + 1, m, n, obstacleGrid);
        int p2 = f(r + 1, c, m, n, obstacleGrid);

        return p1 + p2;
    }
}
