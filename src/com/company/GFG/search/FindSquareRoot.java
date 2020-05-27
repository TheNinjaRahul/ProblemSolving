package com.company.GFG.search;

public class FindSquareRoot {
    public static void main(String[] args) {
//        int data[]={}
        System.out.println(floorSqrt(5l));
    }
    static  long floorSqrt(long x)
    {
        long start=1l,end=x,mid=0,ans=0;
        while(start<=end){
            mid=(start+end)/2;
            if(mid*mid==x){
                return mid;
            }
            if((mid*mid) < x){
                start=mid+1;
                ans=mid;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}
