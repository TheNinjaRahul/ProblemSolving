package com.company.leetcode.string;

public class IsSubsequence {
    public static void main(String[] args) {

    }

    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0 && t.length()>0){
            return true;
        }
        if(s.length()>0 && t.length()==0){
            return false;
        }
        int j=0;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)==s.charAt(j) && j<s.length()){
                j++;
            }
        }
        if(j==s.length()){
            return true;
        }else {
            return false;
        }
    }
}
