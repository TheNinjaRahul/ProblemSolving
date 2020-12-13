package com.company.leetcode.string;

public class MaxRepeating {
    public static void main(String[] args) {
        System.out.println(maxRepeating("ababc", "ab"));
        System.out.println(maxRepeating("ababc", "ba"));
    }

    public static int maxRepeating(String a, String b) {
        if (b.length() > a.length()) return 0;

        int max = 0;
        for (int i = 0; i < a.length(); i++) {
            int k = i;
            int j = 0;
            int count = 0;
            while (k < a.length() && a.charAt(k) == b.charAt(j)) {
                k++;
                j++;
                if (j == b.length()) {
                    j = 0;
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
