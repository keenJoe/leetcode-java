package org.xqd.learning.leetcode.mergesort;

public class LCR170 {
    public int reversePairs(int[] record) {
        if (record == null || record.length == 0) return 0;
        return reversePairs(record, 0, record.length - 1);
    }

    private int reversePairs(int[] record, int l, int r) {
        if (l >= r) return 0;

        int m = (l + r) >> 1;
        return reversePairs(record, l, m) + reversePairs(record, m + 1, r) + merge(record, l, m, r);
    }

    private int merge(int[] record, int l, int m, int r) {
        if (l == r) return 0;

        //需要一个辅助数组，长度是两个有序的数组的合并后的长度
        int[] helper = new int[r - l + 1];
        int count = 0;
        int length = helper.length - 1;

        //既要统计逆序对，同时别忘了合并数组（为什么从后向前呢？如果从前向后，每次左和右进行比较，右侧就都需要从m+1开始）
        //所以这里有一步非常重要，就是拷贝。需要考虑哪一个元素不再使用
        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 > m) {
//            int n = m + 1;
//            while (record[l] > record[n] && n <= r) n++;
//            count = n - n + 1;
//            l++;
            count += record[p1] > record[p2] ? p2 - m : 0;
            helper[length--] = record[p1] > record[p2] ? record[p1--] : record[p2--];
        }

        //完成剩余数组的合并
        while (p1 >= l) {
            helper[length--] = record[p1--];
        }

        while (p2 > m) {
            helper[length--] = record[p2--];
        }

        //复制回原数组
        for (int i = 0; i < helper.length; i++) {
            record[l + i] = helper[i];
        }

        return count;
    }
}
