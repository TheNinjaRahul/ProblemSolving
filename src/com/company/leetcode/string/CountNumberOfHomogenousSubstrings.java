package com.company.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfHomogenousSubstrings {
    public static void main(String[] args) {
        System.out.println(countHomogenous("abbcccaa"));
    }

    public static int countHomogenous(String s) {
        int mod = 1000000007;
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int j = i;
            while (i < s.length() - 1 && s.charAt(i + 1) == c) {
                i++;
            }
            int count = i - j + 1;
            int loop = count;
            for (int k = 1; k <= loop; k++) {
                map.put(c + "" + k, (map.getOrDefault(c + "" + k, 0) + count) % mod);
                count--;
            }
            i++;
        }

//        System.out.println(map);
        int ans = 0;
        for (String key : map.keySet()) {
            ans += map.get(key);
            ans %= mod;
        }
        return ans;
    }
}
