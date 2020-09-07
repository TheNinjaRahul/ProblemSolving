package com.company.leetcode.string;

public class MinimumDeletionCosttoAvoidRepeatingLetters {
    public static void main(String[] args) {

        String s4 = "aaabbbabbbb";
        int[] d4 = {3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1};
        System.out.println(minCost(s4, d4));

        String s3 = "aabaa";
        int d3[] = {1, 2, 3, 4, 1};

        System.out.println(minCost(s3, d3));

        String s1 = "abaac";
        int d1[] = {1, 2, 3, 4, 5};
        System.out.println(minCost(s1, d1));
        String s2 = "abc";
        int[] d2 = {1, 2, 3};
        System.out.println(minCost(s2, d2));
    }

    public static int minCost(String s, int[] cost) {
        int c = 0;
        int i = 0;
        while (i < s.length() - 1) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int j = i;
                while (i < s.length() - 1 && s.charAt(j) == s.charAt(i + 1)) {
                    if (cost[j] < cost[i + 1]) {
                        c += cost[j];
                        j = i + 1;
                        i++;
                    } else {
                        c += cost[i + 1];
                        i++;
                    }
                }
            } else {
                i++;
            }
        }

        return c;


    }
}
