package com.company.leetcode.array;

public class MinimumOperationstoMakeArrayEqual {
    public static void main(String[] args) {

    }

    public int minOperations(int n) {
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=a[i]*2+1;
        }

        int i=0;int j=n-1,count=0;
        while(true){
            while(i<n && a[i]>=a[i+1]){
                i++;
            }
            while(j>=0 && a[j]<=a[j-1]){
                j++;
            }
        }

    }


}
