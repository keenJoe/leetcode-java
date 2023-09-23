package org.xqd.learning.leetcode.array;

/**
 * 74. Search a 2D Matrix
 */
public class SearchA2dMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1}, {3}};
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        boolean b = searchA2dMatrix.searchMatrix(matrix, 3);
        System.out.println(b);
    }

    /**
     * 先使用二分查找确定target在某一行
     * 再确定target所在行的位置
     * 如果有则返回true，否则返回false
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] firstColumn = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firstColumn[i] = matrix[i][0];
        }

        int[] array = confirmRow(matrix, firstColumn, target);
        if (array != null) {
            return binarySearch(array, target);
        }

        return false;
    }

    private int[] confirmRow(int[][] matrix, int[] array, int target) {
        if (array.length == 1) {
            return matrix[0];
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
            if (i + 1 == array.length) {
                if (target >= array[i]) {
                    return matrix[i];
                } else {
                    return matrix[i - 1];
                }
            } else {
                if (target < array[i + 1]) {
                    return matrix[i];
                }
            }
        }

        return null;
    }

    private boolean binarySearch(int[] array, int target) {
        if (array.length == 1) {
            if (array[0] == target) {
                return true;
            } else {
                return false;
            }
        }

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
