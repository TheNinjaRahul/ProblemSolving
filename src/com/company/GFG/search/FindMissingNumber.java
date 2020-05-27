package com.company.GFG.search;

public class FindMissingNumber {
    public static void main(String[] args) {
        int data[]={1,2,3,5,6,7};
        System.out.println(findMissingXOR(data,data.length));
    }

    private static int findMissingXOR(int[] data, int length) {
        int act=data[0];
        for(int i=1;i<data.length;i++){
            act^=data[i];
        }
        int real=1;
        for(int i=2;i<=data.length+1;i++){
            real^=i;
        }

        return act^real;

    }

    private static int findMissing(int[] data,int n) {
        int totalsum= ((n+1)*(n+2))/2;
        for(int i=0;i<n;i++){
            totalsum-=data[i];
        }
        return totalsum;
    }
}
