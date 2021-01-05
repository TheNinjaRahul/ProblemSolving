package com.company.leetcode.string;

public class DecodedStringAtIndex {
    public static void main(String[] args) {
        System.out.println(decodeAtIndex("leet2code3", 10));
    }

    public static String decodeAtIndex(String S, int K) {
        long size = 0;
        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                size *= Integer.parseInt("" + c);
            } else {
                size++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            K %= size;
            if (K % size == 0 && !Character.isDigit(c)) {
                return String.valueOf(c);
            }
            if (Character.isDigit(c)) {
                size /= Integer.parseInt("" + c);
            } else {
                size--;
            }
        }
        return null;

    }

}
