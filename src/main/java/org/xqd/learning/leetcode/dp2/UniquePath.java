package org.xqd.learning.leetcode.dp2;

public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            arr[i][n - 1] = 1;
        }

        for (int i = 0; i <= n - 1; i++) {
            arr[m - 1][i] = 1;
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                arr[i][j] = arr[i][j + 1] + arr[i + 1][j];
            }
        }

        return arr[0][0];
    }
}
