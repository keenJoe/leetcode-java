package org.xqd.learning.leetcode.answer.top100;

public class AddBinary {
    public static String addBinary(String a, String b) {
        if (a == null || a == "") return b;
        if (b == null || b == "") return a;

        char[] aChars = a.length() >= b.length() ? a.toCharArray() : b.toCharArray();
        char[] bChars = a.length() >= b.length() ? b.toCharArray() : a.toCharArray();

        int aLength = aChars.length;
        int bLength = bChars.length;

        int length = aLength + 1;
        char[] result = new char[length];

        int carry = 0;
        for (int i = aLength - 1; i >= 0; i--) {
            char charA = aChars[i];
            char charB = ' ';
            if (bLength - 1 >= 0) {
                charB = bChars[--bLength];
            }

            if (charB != ' ') {
                int numberA = Character.getNumericValue(charA);
                int numberB = Character.getNumericValue(charB);
                int c = 0;
                if (numberA + numberB == 2) {
                    c = carry;
                    carry = 1;
                } else if (numberA + numberB == 1) {
                    c = 1 + carry == 2 ? 0 : 1;
                    carry = 1 + carry == 2 ? 1 : 0;
                } else {
                    c = carry;
                    carry = 0;
                }

                result[--length] = (char) (c + 48);
            } else {
                int numberA = Character.getNumericValue(charA);
                int c = numberA + carry == 2 ? 0 : numberA + carry;
                carry = numberA + carry == 2 ? 1 : 0;
                result[--length] = (char) (c + 48);
            }
        }

        if (carry == 1 && length >= 0) {
            result[0] = (char) (carry + 48);
        }

        return String.valueOf(result).trim();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("110010", "100"));
    }
}
