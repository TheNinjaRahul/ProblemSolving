package com.company.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        System.out.println(largestNumber(data));
    }

    public static String largestNumber(int[] nums) {

        String[] str = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(str[i]);
        }
        Arrays.toString(str);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(str[i]);
        }
        Comparator<String> comparable = (a, b) -> {
            return (b + a).compareTo(a + b);
        };

        Arrays.sort(str, comparable);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
}
