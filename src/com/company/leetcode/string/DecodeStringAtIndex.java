package com.company.leetcode.string;

public class DecodeStringAtIndex {
    public static void main(String[] args) {

    }

    public String decodeAtIndex(String s, int k) {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                String si = sb.toString();
                int n = c - '0';
                // System.out.println(n);
                for (int j = 1; j < n; j++) {
                    sb.append(si);
                }
            } else {
                sb.append(c);
            }

            if (sb.length() >= k) {
                // System.out.println(sb);
                return String.valueOf(sb.charAt(k - 1));
            }

        }

        return "";

    }
}
