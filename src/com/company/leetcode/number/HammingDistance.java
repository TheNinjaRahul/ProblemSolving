package com.company.leetcode.number;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println(hammingDistance2(8,4));

    }

    public static int hammingDistance2(int x, int y) {
        int count=0;
        int n=x^y;
        for(int i=0;i<32;i++){
            if(((n>>i)&1)==1){
                count++;
            }
        }
        return count;
    }

    public static int hammingDistance(int x, int y) {
        int count=0;int bit=0;
        while (bit<32){
            if(x%2 !=y%2){
                count++;
            }
            x=x/2;
            y=y/2;
            bit++;
        }
        return count;
    }
}
