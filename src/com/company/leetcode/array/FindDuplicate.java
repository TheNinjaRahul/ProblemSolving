package com.company.leetcode.array;

public class FindDuplicate {
    public static void main(String[] args) {
        int data[]={1,3,4,2,2};
        System.out.println(findDuplicate(data));

    }

    public static int findDuplicate(int[] nums) {
        if(nums.length==0) return -1;

        int i=0,k=0;
        while(i<nums.length){
            int index=Math.abs(nums[i])-1;

            if(nums[index]<0){
                return Math.abs(nums[i]);
            }else{
                nums[index]=-nums[index];
            }
            i++;
        }

        return -1;
    }
}
