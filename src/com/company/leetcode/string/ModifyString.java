package com.company.leetcode.string;

public class ModifyString {

    public static void main(String[] args) {
        String s = "z?qg??z";
        ModifyString ms = new ModifyString();
        System.out.println(ms.modifyString(s));
    }

    public String modifyString(String s) {
        if (s.length() == 1 & s.charAt(0) == '?') return "a";
        if (s.length() == 1 & s.charAt(0) != '?') return s;

        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i == 0) {
                    sb.setCharAt(i, getChar(sb.charAt(i + 1)));
                } else if (i == s.length() - 1) {
                    sb.setCharAt(i, getChar(sb.charAt(i - 1)));
                } else {
                    sb.setCharAt(i, getChar(sb.charAt(i - 1), sb.charAt(i + 1)));
                }
            }
        }
        return sb.toString();
    }

    private char getChar(char c1, char c2) {
            int a = 'a';
            while (a == c1 || a == c2) {
                a++;
            }
            if (a > 'z') {
                a = 'a';
            }
            return (char) a;
    }

    private char getChar(char c) {
        int a = 'a';
        while (a == c) {
            a++;
        }
        if (a > 'z') {
            a = 'a';
        }
        return (char) a;
    }
}
