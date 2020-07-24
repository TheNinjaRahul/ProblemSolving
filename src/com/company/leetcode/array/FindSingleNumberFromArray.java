package com.company.leetcode.array;

public class FindSingleNumberFromArray {
    public static void main(String[] args) {
        System.out.println((5 >> 3));
        System.out.println(((5 >> 2) & 1)==1);
        System.out.println(singleNumber(new int[]{2,2,3,2}));
    }




    public static int singleNumber(int[] nums) {

        int ans=0;
        for(int i=0;i<=32;i++){
            int sum=0;
            for(int j=0;j<nums.length;j++){
                if(((nums[j] >> i) & 1) == 1){
                    sum++;
                }
            }
            sum%=3;
            if(sum!=0){
                sum=sum<<i;
                ans=ans|sum;
            }
        }

        return ans;
    }
}
