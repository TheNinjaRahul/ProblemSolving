package com.company.leetcode.number;

import java.util.Map;

public class DivideTow {
    public static void main(String[] args) {

        System.out.println(divide(10,-3));
//        System.out.println(divide(-2147483648,-1));
        System.out.println(divide(-2147483648, 1));
//        int ans=16<<2;
//        System.out.println(ans);
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println("5 << " + i + "=" + (5 << i));
//        }
//        /*
//        5 << 0=5
//        5 << 1=10
//        5 << 2=20
//        5 << 3=40
//        5 << 4=80
//        * */
//        for (int i = 0; i < 5; i++) {
//            System.out.println("3 >> " + i + "=" + (3 >> i));
//        }

    }

    public static int divide(int dividend, int divisor) {
        {
            int result = 0;

            int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;

            long divnd = Math.abs(dividend);
            long div = Math.abs(divisor);

            if (dividend == -2147483648 && divisor == -1) {
                return 2147483647;
            }


            for (int i = 31; i >= 0; i--) {
                if (divnd >= (div << i)) {
                    divnd -= (div << i);
                    result += (1 << i);
                }
            }

            return result * sign;
        }
    }
}
