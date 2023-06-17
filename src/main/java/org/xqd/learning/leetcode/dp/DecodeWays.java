package org.xqd.learning.leetcode.dp;

/**
 * 91. Decode Ways
 */
public class DecodeWays {

    public int numDecodings(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        int[] table = new int[length];
        table[length] = 1;

        /**
         * 现在开始填dp表了，但是如何填是一个问题。
         * 在递归的方法中，每一个位置依赖了i+1 和 i + 2位置的值，所以，需要从右向左填dp
         */
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] != '0') {
                int p1 = table[i + 1];
                if (i + 1 < array.length && (array[i] - '0') * 10 + array[i + 1] - '0' <= 26) {
                    p1 += table[i + 2];
                }
                table[i] = p1;
            }
        }
        return table[0];
    }

    /**
     * dp 表是几维有递归决定
     * 递归变化的元素只有index的大小，所以这个dp表用一维数组表示就行
     */
    public int dp(char[] array) {
        int length = array.length;
        int[] table = new int[length];
        table[length] = 1;

        for (int i = 0; i <= array.length; i++) {
            if (array[i] != '0') {
                int p1 = table[i + 1];
                if (i + 1 < array.length && (array[i] - '0') * 10 + array[i + 1] - '0' <= 26) {
                    p1 += table[i + 2];
                }
                table[i] = p1;
            }
        }
        return table[0];
    }

    public int process(char[] array, int index) {
        //说明找到了一种情况，必须index == length，才能说明找到一种情况，因为index == length - 1 ，可以index位置此时是0
        if (index == array.length) {
            return 1;
        }

        //这种情况说明前面的判断有误
        if (array[index] == '0') {
            return 0;
        }

        //正常情况
        //执行到这里，说明index位置的数字可以单转为字母

        //index不和index+1组合，开始从index+1转换
        int p1 = process(array, index + 1);

        //index 和 index + 1 组合，开始从index+2转换
        if (index + 1 < array.length && (array[index] - '0') * 10 + array[index + 1] - '0' <= 26) {
            p1 += process(array, index + 2);
        }

        return p1;
    }
}
