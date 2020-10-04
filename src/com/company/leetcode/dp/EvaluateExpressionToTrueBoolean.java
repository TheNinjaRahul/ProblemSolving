package com.company.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

public class EvaluateExpressionToTrueBoolean {
    public static void main(String[] args) {
        System.out.println(cnttrue("F|T^T&F"));
    }

    public static int cnttrue(String s) {
        Map<String, Integer> map = new HashMap<>();
        return solve(s, 0, s.length() - 1, true, map);
    }

    private static int solve(String s, int i, int j, boolean target, Map<String, Integer> map) {

        if (i > j) return 0;

        if (i == j) {
            return s.charAt(i) == (target ? 'T' : 'F') ? 1 : 0;
//            if (s.charAt(i) == 'T' && target) {
//                return 1;
//            }
//            if (s.charAt(i) == 'F' && !target) {
//                return 1;
//            }
//            return 0;
        }
        String key = "" + i + "" + j + "" + target;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {

            int lt = solve(s, i, k - 1, true, map);
            int lf = solve(s, i, k - 1, false, map);
            int rt = solve(s, k + 1, j, true, map);
            int rf = solve(s, k + 1, j, false, map);

            if (s.charAt(k) == '&') {
                if (target) {
                    ans += lt * rt;
                } else {
                    ans += (lt * rf) + (lf * rt) + (lf * rf);
                }
            } else if (s.charAt(k) == '|') {
                if (target) {
                    ans += (lt * rt) + (lt * rf) + (lt * rt);
                } else {
                    ans += lf * rf;
                }
            } else if (s.charAt(k) == '^') {
                if (target) {
                    ans += (lt * rf) + (lf * rt);
                } else {
                    ans += (lf * rf) + (lt * rt);
                }
            }
        }

        map.put(key, ans);
        return ans;

    }

}
