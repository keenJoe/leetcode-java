package org.xqd.learning.leetcode;

/**
 * @author XuQidong
 * @date 2022/7/27 18:18
 */
public class TestByte {
    public static void main(String[] args) {
//        byte tByte = 1;
//        if ("0x01".equals(1)) {
//            System.out.println("here");
//        }
//        String tString = Integer.toBinaryString((tByte & 0xFF)).toString();
//        System.out.println(tString);

        byte test[] = new byte[3];
        test[0] = 0x01;

        byte b = 0x01;

        System.out.println(test[0]);

        System.out.println(Integer.toHexString(test[0]));

        System.out.printf("0x%02X", test[0]);
    }
}
