package com.company.GFG.sort;

import java.util.Arrays;

public class FindTriplets {
    public static void main(String[] args) {
        int a[]={3 ,5 ,4};
        int b[]={6 ,4, 9 ,7 ,8};
        System.out.println(findNumberOfTriangles(a,a.length));
        System.out.println(findNumberOfTriangles(b,b.length));
    }
    static long findNumberOfTriangles(int a[], int n)
    {
        Arrays.sort(a);
        int count=0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int k=j+1;
                while(k<n){
                    if(a[i]+a[j]>a[k]){
                        count++;
                    }
                    k++;
                }
            }
        }
        return count;

    }
}
