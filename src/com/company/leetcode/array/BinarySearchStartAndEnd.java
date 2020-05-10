package com.company.leetcode.array;

public class BinarySearchStartAndEnd {
    public static void main(String[] args) {

        int data[]={5,7,7,8,8,8,8,8,8,10};
        int[] result=searchRange2(data,8);
        System.out.println(result[0] + "  " +result[1]);
    }

    public static int[] searchRange2(int[] nums, int target) {
        int []result={-1,-1};

        int start=findFirst(nums,target);
        int last=findLast(nums,target);

        return new int[]{start,last};
    }

    private static int findLast(int[] nums, int target) {
        int low=0,high=nums.length-1,mid=0;
        int index=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                index=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return index;
    }

    private static int findFirst(int[] nums, int target) {
        int low=0,high=nums.length-1,mid=0;
        int index=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                index=mid;
                high=mid-1;
            }else if(nums[mid]>target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return index;
    }

    public static int[] searchRange(int[] nums, int target) {
        int low=0,high=nums.length-1;
        return search(nums,target,low,high);
    }

    private static int[] search(int[] nums, int target, int low, int high) {
        if((low>high)){
            return new int[]{-1,-1};
        }
        int[] start,end;
        int sval=-1,eval=-1;

       while(low<=high){
           int mid=(low+high)/2;
           if(nums[mid]==target){
               start = search(nums,target,low,mid-1);
               end = search(nums,target,mid+1,high);


               if(start[1] == -1){
                    sval=mid;
               }else{
                   if(start[0]==-1){
                       sval=mid;
                   }else{
                       sval=start[1];
                   }
               }

               if(end[0] == -1){
                   eval=mid;
               }else{
                   if(start[1]==-1){
                       eval=mid;
                   }else{
                       eval=end[0];
                   }
               }

               if(sval != -1 && eval != -1) return new int[]{sval,eval};
               if(sval == -1 && eval != -1) return new int[]{-1,eval};
               if(sval != -1 && eval == -1) return new int[]{sval,-1};
           }else if(target>nums[mid]){
               low=mid+1;
           }else {
               high=mid-1;
           }
       }

       return new int[]{-1,-1};
    }
}
