package com.company.GFG.Array;

import java.util.Arrays;

public class InversionOfArray {
    public static void main(String[] args) {
        long[] data={2 ,4 ,1 ,3 ,5};
        System.out.println(inversionCount(data,data.length));
    }

    public static int inversionCount(long  a[],  long N)
    {
        return mergeSortAndCount(a,0,N-1);
    }

    private static int mergeSortAndCount(long[] a, int l, long r) {
        int mid= (int) (l+((r-l)/2));
        int count=0;

        if(l<r){
            count+=mergeSortAndCount(a,l,mid);
            count+=mergeSortAndCount(a,mid+1,r);
            count+=merge(a,l,mid,r);
        }
       return count;
    }

    private static int merge(long[] a, int l, int mid, long r) {
        long[] f= Arrays.copyOfRange(a,l,mid+1);
        long[] s=Arrays.copyOfRange(a,mid+1, (int) (r+1));
        int k=l,swap=0;
        int i=0,j=0;

        while(i<f.length && j< s.length){
            if(f[i]<s[j]){
                a[k++]=f[i];
                i++;
            }else{
                a[k++]=s[j];
                swap+=(mid+1- (l+i));
                j++;
            }
        }
        while(i<f.length){
            a[k++]=f[i++];
        }
        while(j<s.length){
            a[k++]=s[j++];
        }
        return swap;
    }


}
