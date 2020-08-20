package com.company.leetcode.string;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        if(s.length()==0) return true;

        s=s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<=j){
            if(!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))){
                i++;
                continue;
            }
            if(!(Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j)))){
                j--;
                continue;
            }
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
