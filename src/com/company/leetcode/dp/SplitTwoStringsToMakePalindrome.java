package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
        SplitTwoStringsToMakePalindrome sp = new SplitTwoStringsToMakePalindrome();
        System.out.println(sp.checkPalindromeFormation("x", "y"));
        System.out.println(sp.checkPalindromeFormation("ulacfd", "jizalu"));
        System.out.println();
    }

    Map<String, Boolean> map = new HashMap<>();

    public boolean checkPalindromeFormation(String s1, String s2) {
        return find(s1, s2, map);
    }

    boolean find(String s1, String s2, Map<String, Boolean> map) {
        int n = s1.length();
//        StringBuilder apref=new StringBuilder()
        for (int k = 0; k < n; k++) {
            String apref = s1.substring(0, k);
            String asuf = s1.substring(k);
            String bpref = s2.substring(0, k);
            String bsuf = s2.substring(k);

            String key1 = apref + bsuf;
            boolean ans1 = false;
            if (!map.containsKey(key1)) {
                if (isPalin(key1)) {
                    return true;
                }
                map.put(key1, false);
            }
            String key2 = bpref + asuf;
            if (!map.containsKey(key2)) {
                if (isPalin(key2)) {
                    return true;
                }
                map.put(key2, false);
            }
        }
        return false;
    }

    public boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
