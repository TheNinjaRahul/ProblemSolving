package com.company.leetcode.number;

public class ThousandSeparator {
    public static void main(String[] args) {
        System.out.println(thousandSeparator(123456789));
    }

    public static String thousandSeparator(int n) {
        String s = "";
        if (n == 0) return "0";
        int count = 0;
        while (n != 0) {
            int num = n % 10;
            n = n / 10;
            if (count == 3) {
                s = num + "." + s;
                count = 0;
            } else {
                s = num + s;
            }
            count++;
        }
        return s;
    }
}
