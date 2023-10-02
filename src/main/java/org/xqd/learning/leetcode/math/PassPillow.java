package org.xqd.learning.leetcode.math;

/**
 * 2582. Pass the Pillow
 */
public class PassPillow {
    public int passThePillow(int n, int time) {
        int k = n - 1;
        int a = time / k;
        int b = time % k;
        int currentValue = 0;

        //简化后就是这个样子
        if (a % 2 == 0) {
            currentValue = 1 + b;
        } else {
            currentValue = n - b;
        }

        //达到队头或者队尾
//        if (b == 0) {
//            //在队头
//            if (a % 2 == 0) {
//                currentValue = 1;
//            } else {
//                //在队尾
//                currentValue = n;
//            }
//        } else {
//            //不在队头和队尾
//            if (a == 0) {
//                currentValue = 1 + b;
//            } else {
//                if (a % 2 != 0) {
//                    currentValue = n - b;
//                } else {
//                    currentValue = 1 + b;
//                }
//            }
//        }

        return currentValue;
    }
}
