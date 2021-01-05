package com.company.leetcode.string;

import sun.security.krb5.internal.PAData;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DecodeWays {

    static class Pair{
        int a;
        int f;
        Pair(int a,int f){
            this.a=a;
            this.f=f;
        }
        public String toString(){
            return "a="+a +" and f="+f;
        }
    }

    public static void main(String[] args) {

        PriorityQueue<Pair> q=new PriorityQueue<>((a,b)->{
            return 0;
        });
        PriorityQueue<Pair> q2=new PriorityQueue<>(q);

        Pair p=new Pair(1,2);
        System.out.println(numDecodings("223"));
        System.out.println(numDecodings("123123"));
    }

    public static int numDecodings(String s) {

        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return rec(0, s, dp);


    }

    private static int rec(int i, String s, int[] dp) {
        if (s.length() == 0) return 1;
        if (s.charAt(0) == '0') return 0;
        if (dp[i] != -1) return dp[i];
        int a = s.charAt(0) - '0';
        int way1 = rec(i + 1, s.substring(1), dp);
        int way2 = 0;
        if (s.length() > 1) {
            int b = s.charAt(1) - '0';
            if (((a * 10) + b) <= 26) {
                way2 = rec(i + 2, s.substring(2), dp);
            }
        }
        dp[i] = way1 + way2;
        return dp[i];
    }
}
