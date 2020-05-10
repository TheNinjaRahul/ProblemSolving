package com.company.challenges;

import java.math.BigInteger;
import java.util.LinkedList;

public class Factorial {
    public static void main(String[] args) {
//        System.out.println(fact(25));
//        System.out.println(fact2(25));
        fact(25);
        fact2(25);
    }

    private static boolean fact(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(fact);
        return true;
    }

    private static boolean fact2(int n) {
        BigInteger fact = BigInteger.ONE;
        for (int i = n; i >= 1; i--) {
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
//            System.out.println(i);
        }

        LinkedList<String> data;

        System.out.println(fact);
        return true;
    }


}
