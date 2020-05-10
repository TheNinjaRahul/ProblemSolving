package com.company.challenges;

import java.math.BigInteger;

public class FindDigit {
    public static void main(String[] args) {

    }
    static int findDigits(int n) {
        String s=String.valueOf(n);
        int c=0;
        for(int i=0;i<s.length();i++){
            if(n%(Integer.parseInt(String.valueOf(s.charAt(i))))==0){
                c++;
            }
        }



        return c;
    }

}
