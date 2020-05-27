package com.company.GFG.search;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingElementsInTwoArrays {
    public static void main(String[] args) {
        int a[] = {4, 8, 7, 5, 1};
        int b[] = {4, 4,8, 3, 0, 1, 1, 5};
//       countEleLessThanOrEqual(a,b,a.length,b.length);
       int c[]={1 ,2 ,3 ,4 ,7 ,9};
        int d[]={0 ,1 ,2 ,1 ,1 ,4};
        countEleLessThanOrEqual(c,d,c.length,d.length);

    }

    public static void countEleLessThanOrEqual(int a[], int b[], int m, int n)
    {
        Arrays.sort(b);
        for(int i=0;i<m;i++){
            System.out.print(find(b,a[i])+" ");
        }
    }

    private static int find(int[] b, int i) {
        int start=0,end=b.length-1,ans=-1,mid=0;
        while (start<=end){
            mid=start+((end-start)/2);
            if(b[mid]>i){
                end=mid-1;
//                ans=mid;
            }else{
                start=mid+1;
//                ans=mid;
            }
        }
        return end+1;
    }
}
