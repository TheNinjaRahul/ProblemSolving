package com.company.leetcode.string;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        System.out.println(makeGood("Pp"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("s"));


    }

    public static String makeGood(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (i == c.length - 1) {
                sb.append(c[i]);
                continue;
            }
            if (Character.isUpperCase(c[i])) {
                char first = Character.toLowerCase(c[i]);
                if (first == c[i + 1]) {
                    sb = new StringBuilder();
                    c = getCharArray(i, c);
                    i = -1;
                    continue;
                }
            } else {
                if (Character.isUpperCase(c[i + 1])) {
                    char second = Character.toLowerCase(c[i + 1]);

                    if (c[i] == second) {
                        sb = new StringBuilder();
                        c = getCharArray(i, c);
                        i = -1;
                        continue;
                    }
                }
            }
            sb.append(c[i]);
        }
        return sb.toString();
    }

    private static char[] getCharArray(int index, char[] c) {
        char[] cn = new char[c.length - 2];
        int j = 0;
        for (int i = 0; i < c.length; i++) {
            if (i == index || i == index + 1) {
                continue;
            }
            cn[j++] = c[i];
        }
        return cn;
    }
}
