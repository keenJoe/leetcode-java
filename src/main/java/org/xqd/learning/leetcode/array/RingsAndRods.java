package org.xqd.learning.leetcode.array;

/**
 * 2103. Rings and Rods
 */
public class RingsAndRods {
    public static void main(String[] args) {
        char ch = '9';
        int intValue = (int) ch;
        System.out.println(intValue);

        countPoints("B0B6G0R6R0R6G9");
    }

    public static int countPoints(String rings) {
        int[][] array = new int[10][3];

        for (int i = 0; i < rings.length(); i++) {
            if ((i + 1) % 2 == 0) {
                char color = rings.charAt(i - 1);
                char index = rings.charAt(i);
                int j = index;
                if (color == 'R') {
                    array[j - 48][0] = 1;
                } else if (color == 'G') {
                    array[j - 48][1] = 1;
                } else if (color == 'B') {
                    array[j - 48][2] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int color = array[i][0] + array[i][1] + array[i][2];
            if (color == 3) {
                count += 1;
            }
        }

        return count;
    }
}
