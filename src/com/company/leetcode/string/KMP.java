package com.company.leetcode.string;

public class KMP {
    public static void main(String[] args) {
        System.out.println(contains("abxabcabcaby", "aabaabaaa"));
        System.out.println(contains("abxabcabcaby", "abcaby"));
    }

    private static boolean contains(String s1, String s2) {
        int[] preCal = new int[s2.length()];

        int i = 0;
        for (int j = 1; j < s2.length(); j++) {
            if (s2.charAt(i) == s2.charAt(j)) {
                preCal[j] = i + 1;
                i++;
            } else {
                while (i != 0 && s2.charAt(preCal[i - 1]) != s2.charAt(j)) {
                    i = preCal[i - 1];
                }
                preCal[j] = i;
            }
        }

        i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            } else {
                if (j != 0) {
                    j = preCal[j - 1];
                    i--;
                }
            }
            i++;
        }
        return j == s2.length();

    }

}
