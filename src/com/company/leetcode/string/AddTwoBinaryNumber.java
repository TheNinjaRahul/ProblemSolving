package com.company.leetcode.string;

public class AddTwoBinaryNumber {
    public static void main(String[] args) {

        System.out.println(addBinary("110111", "101"));

        System.out.println(addBinary("110010", "10111"));

        System.out.println(addBinary("1", "111"));

//        System.out.println(addBinary("1010", "1011"));
    }


    public static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < a.length() || i < b.length() || carry != 0) {
            int x = 0;
            int y = 0;
            if (i < a.length() && a.charAt(a.length() - 1 - i) == '1') x = 1;
            if (i < b.length() && b.charAt(b.length() - 1 - i) == '1') y = 1;
            sb.insert(0, (x + y + carry) % 2);
            carry = (x + y + carry) / 2;
            i++;
        }
        return sb.toString();
    }

    public static String addBinary2(String a, String b) {
        if (a.length() == 0 && b.length() == 0) return "";
        if (a.length() == 0 && b.length() != 0) {
            return b;
        }
        if (a.length() != 0 && b.length() == 0) {
            return a;
        }

        if (a.length() < b.length()) {
            String t = a;
            a = b;
            b = t;
        }

        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (al >= 0 && bl >= 0) {
            char aa = a.charAt(al);
            char bb = b.charAt(bl);
            if (aa == '1' && bb == '1' && carry == 0) {
                sb.insert(0, '0');
                carry = 1;
            } else if (aa == '1' && bb == '1' && carry == 1) {
                sb.insert(0, '1');
                carry = 1;
            } else if ((aa == '1' || bb == '1') && carry == 0) {
                sb.insert(0, '1');
            } else if (aa == '1' || bb == '1' && carry == 1) {
                sb.insert(0, '0');
                carry = 1;
            } else if (aa == '0' && bb == '0' && carry == 1) {
                sb.insert(0, '1');
                carry = 0;
            } else {
                sb.insert(0, '0');
            }
            al--;
            bl--;
        }

        while (al >= 0) {
            if (a.charAt(al) == '1' && carry == 1) {
                sb.insert(0, '0');
                carry = 1;
            } else if (a.charAt(al) == '1' || carry == 1) {
                sb.insert(0, '1');
                carry = 0;
            } else {
                sb.insert(0, '0');
            }
            al--;
        }
        if (carry == 1) sb.insert(0, '1');
        return sb.toString();
    }
}
