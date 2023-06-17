package org.xqd.learning.leetcode.dp;

/**
 * 91. Decode Ways
 */
public class DecodeWays {

    public int numDecodings(String s) {
        return process(s.toCharArray(), 0);
    }

    public int process(char[] array, int index) {
        //说明找到了一种情况，必须index == length，才能说明找到一种情况，因为index == length - 1 ，可以index位置此时是0
        if (index == array.length - 1) {
            return 1;
        }

        //这种情况说明前面的判断有误
        if (array[index] == '0') {
            return 0;
        }

        //正常情况
        //执行到这里，说明index位置的数字可以单转为字母

        //index不和index+1组合，开始从index+1转换
        int p1 = process(array,index + 1);

        //index 和 index + 1 组合，开始从index+2转换
        if (index + 1 < array.length && (array[index] - '0') * 10 + array[index + 1] - '0' <= 26) {
            p1 += process(array, index + 2);
        }

         return p1;
    }
}
