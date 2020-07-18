package com.company.leetcode.string;

import java.util.Arrays;

public class ReverseWord {
    public static void main(String[] args) {

        System.out.println(reverseWords(""));
//        System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords("a good   example"));

    }

    public static String reverseWords(String s) {
        if(s.trim().length()==0) return s.trim();

        StringBuilder sb = new StringBuilder(s);
        while (sb.charAt(0) == ' ') {
            sb.deleteCharAt(0);
        }

        sb = sb.reverse();
        int i = 0;
        int start = i;
        StringBuilder sbd = new StringBuilder();
        while (i < sb.length()) {

            while (i < sb.length() && sb.charAt(i) != ' ') i++;

            sbd.append(" ");
            int end = i - 1;
            while (end >= start) {
                sbd.append(sb.charAt(end--));
            }
            while (i < sb.length() && sb.charAt(i) == ' ') i++;
            start = i;
        }

        return sbd.toString().trim();

    }

    public static String reverseWords2(String s) {
        String str[] = s.split(" ", -1);
        s = "";
        for (String is : str) {
            is = is.trim();
            if (is == null || is.length() == 0) {
                continue;
            }
            if (s.equals("")) {
                s += is;
            } else {
                s += " " + is;
            }

        }
        System.out.println(Arrays.toString(str));
        System.out.println(s);
        char c[] = s.toCharArray();
        int i = 0;
        int j = 1;
        while (j < s.length()) {
            if (j == s.length() - 1 || s.charAt(j) == ' ') {
                int k = j - 1;
                if (j == s.length() - 1) k = j;
                while (i <= k) {
                    swapchar(c, i++, k--);
                }
                i = j + 1;
            }
            j++;
        }

        i = 0;
        j = c.length - 1;
        while (i < j) {
            swapchar(c, i++, j--);
        }

        return String.valueOf(c);
    }

    private static void swapchar(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
