package com.company.leetcode.number;

public class MyPow {
    public static void main(String[] args) {
        double x = 2.00000;
        System.out.println(myPow(x, -2));
    }

    public static double myPow(double x, int n) {


        if (n < 0) {
            return negativePow(x, n);
        } else {
            return positivePow(x, n);
        }
    }

    private static double positivePow(double x, int n) {
        if (n == 0) return 1;
        double value = positivePow(x, n / 2);
        if (n % 2 == 0) {
            return value * value;
        } else {
            return x * value * value;
        }
    }

    private static double negativePow(double x, int n) {
        if (n == -1) {
            return 1 / x;
        }
        double smallval = myPow(x, n / 2);
        if (n % 2 == 0) {
            return smallval * smallval;
        } else {
            return (1 / x) * smallval * smallval;
        }

    }
}
