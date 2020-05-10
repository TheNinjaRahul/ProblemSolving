package com.company.leetcode;

public class ContainerWithMostWater {
    public static void main(String[] args) {
    int [] data=new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater(data));
    }

    private static int  containerWithMostWater(int[] data) {
        int result = 0 ;
        int left=0,right=data.length-1;

        while(left<right){
            int diff=right-left;
            int width=0;
            if(data[left]<data[right]){
                width=diff*data[left];
                left++;
            }else{
                width=diff*data[right];
                right--;
            }

            if(width>result){
                result=width;
            }

        }

        return result;
    }

}
