package com.company.leetcode.string;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        String s = "aabaaba";
        System.out.println(repeatedSubstringPattern(s));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int i = 0, j = 1;
        StringBuilder sb = new StringBuilder();
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.substring(i, j));
                if (s.length() % sb.length() == 0) {
                    int times = s.length() / sb.length();
                    for (int k = 1; k < times; k++) {
                        sb.append(s.substring(i, j));
                    }
                    if (s.equals(sb.toString())) {
                        return true;
                    }
                }
            }
            sb.setLength(0);
            j++;
        }

        return false;

    }
}
