package com.company.leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccba"));
    }

    public static String longestPalindrome(String s) {
        if (s.equals("")){
            return "";
        }
        int start=0,endIndex=0;
        int length=0;

        for(int i=0;i<s.length();i++){
            int len1=expandPalindrom(s,i,i);
            int len2=expandPalindrom(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>length){
                start=i-((len-1)/2);
                endIndex=i+(len/2);
                length=len;
            }

        }
        return s.substring(start,endIndex+1);
    }

    private static int expandPalindrom(String s, int left, int  right) {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        int len=right-left-1;
        return len;
    }
}
