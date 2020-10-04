package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {


    public static void main(String[] args) {
        ScrambledString ss = new ScrambledString();
        System.out.println(ss.isScramble("ab", "ba"));
        System.out.println(ss.isScramble("great", "rgeat"));
    }


    HashMap<String, Boolean> map;

    public boolean isScramble(String s1, String s2) {

        map = new HashMap();
        return find(s1, s2);
    }

    boolean find(String s1, String s2) {


        if (s1.equals("")) return false;
        if (s1.equals(s2)) return true;

        int n = s1.length();

        if (n == 1) {
            return false;
        }

        if (map.containsKey(s1 + "-" + s2))
            return map.get(s1 + "-" + s2);


        boolean flag = false;

        for (int k = 0; k < n - 1; k++) {

            flag = (find(s1.substring(0, k + 1), s2.substring(0, k + 1)) && find(s1.substring(k + 1, n), s2.substring(k + 1, n)))
                    || (find(s1.substring(0, k + 1), s2.substring(n - (k + 1), n)) && find(s1.substring(k + 1, n), s2.substring(0, n - (k + 1))));

            map.put(s1 + "-" + s2, flag);

            if (flag)
                return true;
        }

        return flag;
    }

    public static boolean isScramble2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        Map<String, Boolean> map = new HashMap<>();
        return solve(s1, s2, map);
    }

    private static boolean solve(String s1, String s2, Map<String, Boolean> map) {


        if (s1.length() == 0) return false;
//        if (s1.length() == 0 || s2.length() == 0) return false;
//        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        if (s1.length() == 1) return false;


        String key = s1 + "-" + s2;
        if (map.containsKey(key)) return map.get(key);
        boolean ans = false;
        for (int k = 0; k < s1.length() - 1; k++) {
            boolean cond11 = solve(s1.substring(0, k + 1), s2.substring(s2.length() - (k + 1), s2.length()), map);
            boolean cond12 = solve(s1.substring((k + 1)), s2.substring(0, s2.length() - (k + 1)), map);

            boolean cond21 = solve(s1.substring(0, k + 1), s2.substring(0, k + 1), map);
            boolean cond22 = solve(s1.substring(k + 1), s2.substring(k + 1), map);
            if ((cond11 && cond12) || (cond21 && cond22)) {
                ans = true;
                break;
            }
        }
        map.put(key, ans);
        return ans;
    }
}
