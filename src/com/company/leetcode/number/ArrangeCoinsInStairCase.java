package com.company.leetcode.number;

public class ArrangeCoinsInStairCase {
    public static void main(String[] args) {
        System.out.println(arrangeCoins2(11));
    }

    public static int arrangeCoins2(int n) {
        int left=0,right=n;
        long k=0;
        long current=0;
        while(left<=right){
            k=(left+(right-left)/2);
            current=(k*(k+1))/2;
            if(current==n) return (int)k;
            if(n<current){
                right= (int) (k-1);
            }else {
                left= (int) (k+1);
            }
        }
        return right;
    }

    public static int arrangeCoins(int n) {
        if(n==1) return n;
        int cur=1;
        int count=0;
        while(n>0){
            n=n-cur;
            if(n>0){
                count++;
                cur++;
            }else{
                break;
            }
        }
        return count;
    }
}
