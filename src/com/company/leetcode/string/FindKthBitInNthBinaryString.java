package com.company.leetcode.string;

public class FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
        System.out.println(findKthBit(4, 11));
        System.out.println(findKthBit(1, 1));
        System.out.println(findKthBit(2, 3));

    }

//    public static char findKthBit(int n, int k) {
//
//        String dp[] = new String[n + 1];
//
//        dp[1] = "0";
//
//        for (int i = 2; i <= n; i++) {
//            String b = Integer.toBinaryString(i);
//            System.out.println(b);
//            //+" 1" + reverse(invert(Integer.toBinaryString(i)));
//
//            dp[i] = dp[i - 1] + "1" + reverse(invert(dp[i - 1]));
//            // System.out.println("i " + i + " value " + dp[i]);
//
//        }
//
//        // System.out.println(dp[n]);
//        String t = dp[n];
//        if (k - 1 >= 0)
//            return dp[n].charAt(k - 1);
//
//        return '\0';
//
//    }
//
//    public static String invert(String input) {
//        StringBuilder sb = new StringBuilder();
//
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '1')
//                sb.append("0");
//            else
//                sb.append("1");
//        }
//
//        // System.out.println(sb);
//        return sb.toString();
//    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    public static char findKthBit(int n, int k) {
        String e = generateStrig(n, k);
        return e.charAt(k - 1);
    }

    private static String generateStrig(int n, int k) {
        String s = "0";
        for (int i = 1; i < n; i++) {
            s = s + "1" + (invert(s));
            System.out.println(s + ":" + Integer.parseInt(s, 2));
        }
        return s;
    }


    private static String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.reverse().toString();
    }
}
