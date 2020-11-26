package com.company.leetcode.string;

import java.util.Arrays;

public class SmallestStringWithAGivenNumericValue {
    public static void main(String[] args) {
        System.out.println(getSmallestString(3, 54));
    }

    public static String getSmallestString(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i = n - 1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char) (k + 'a' - 1);
                    k -= arr[i] - 'a' + 1;
                }
            } else
                break;
            k += i;
        }
        return String.valueOf(arr);
    }
}
