package com.company.leetcode.number;

import javax.swing.plaf.IconUIResource;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay2(3));
    }

    public static String countAndSay2(int n) {
        if (n == 1) {
            return "1";
        }
//        if (n == 2) {
//            return "11";
//        }

        String result = "1";
        StringBuilder sb;
        for (int i = 1; i < n; i++) {
            char c=result.charAt(0);
            sb=new StringBuilder();
            int count=1;
            for (int j = 1; j < result.length(); j++) {

                if (c == result.charAt(j)) {
                    count++;
                } else {
                    sb.append(count + "" + result.charAt(j - 1));
                    c=result.charAt(j);
                    count=1;
                }
            }
            sb.append(count + "" + result.charAt(result.length()-1));
            result=sb.toString();
        }
        return result;

//            if (result.charAt(result.length()-2) != result.charAt(result.length()-1)) {
//                count=0;
//            }
//            inner += (count + 1) + String.valueOf(result.charAt(result.length() - 1));
//
////            inner+=(count+1)+String.valueOf(result.charAt(result.length()-1));
//            result = inner;
//        }
//
//        return result;
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String result = "11";

        for (int i = 2; i < n; i++) {
            String inner = "";
            int count = 0;
            for (int j = 0; j < result.length() - 1; j++) {
                if (result.charAt(j) != result.charAt(j + 1)) {
                    count++;
                    inner += (count) + String.valueOf(result.charAt(j));
                    count = 0;
                } else {
                    count++;
                }
            }

            if (result.charAt(result.length()-2) != result.charAt(result.length()-1)) {
                count=0;
            }
            inner += (count + 1) + String.valueOf(result.charAt(result.length() - 1));

//            inner+=(count+1)+String.valueOf(result.charAt(result.length()-1));
            result = inner;
        }

        return result;
    }
}
