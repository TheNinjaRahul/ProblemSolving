package com.company.leetcode;

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(-5345));
    }

    private static int reverse(int x) {
        boolean f=false;
        if(x<0){
            f=true;
        }

        int reuslt=0;
//        int i=0;
        while(x!=0){
            int mod=x%10;
            x=x/10;
            reuslt=reuslt*10;
            reuslt+=mod;
        }

        return reuslt;//  f == true? reuslt*-1 : reuslt;
    }
}
