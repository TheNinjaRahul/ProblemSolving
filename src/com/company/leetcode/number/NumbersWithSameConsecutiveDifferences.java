package com.company.leetcode.number;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NumbersWithSameConsecutiveDifferences {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(numsSameConsecDiff(4, 1)));
        System.out.println(Arrays.toString(numsSameConsecDiff(3, 1)));

        System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
    }

//    public static int[] numsSameConsecDiff(int N, int K) {
//
//
//    }

    public static int[] numsSameConsecDiff(int N, int K) {
        List<String> list = new LinkedList<>();
        int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        if ((N == 1)) {
            return num;
        }

        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < num.length; j++) {
                StringBuffer sb = new StringBuffer();
                sb.append(num[i]);
//                if (i == j) continue;
                if (Math.abs(num[i] - num[j]) == K) {
                    sb.append(num[j]);
                    rec(sb, N, K, num, j, list);
                    j++;
                }
            }
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = Integer.parseInt(list.get(i));
        }
        return nums;
    }

    private static void rec(StringBuffer sb, int n, int k, int[] num, int x, List<String> list) {



        if (sb.length() == n) {
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (Math.abs(num[x] - num[i]) == k) {
                sb.append(num[i]);
                rec(sb, n, k, num, i, list);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
