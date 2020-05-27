package com.company.GFG.search;

public class FindTransitionPoint {
    public static void main(String[] args) {
//        int data[]={0,0,0,0,0,1,1,1};
        int data[]={1};
        System.out.println(findLastZeroIndex(data));


    }

    private static int findLastZeroIndex(int[] data) {
        int start=0,end=data.length-1,mid=0,ans=0;

        while(start<=end){
            mid=(start+end)/2;

            if(data[mid]==1){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }


}
