package com.company.leetcode.sort;

import java.util.Arrays;

/****
 *
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 *
 */
public class Sort012 {
    public static void main(String[] args) {
//        int []data={0 ,2 ,1 ,2 ,0};
        int[] data={2,0,2,1,1,0};
        segragate012(data,data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void segragate012(int a[], int N){

        int low=0,mid=0,high=N-1;

        while(mid<=high){

            switch (a[mid]){
                case 0:
                    swapa(a,mid,low);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;break;
                case 2:
                    swapa(a,mid,high);
                    high--;
                    break;
            }

        }
    }

    private static void swapa(int[] a, int low, int high) {
        int temp=a[low];
        a[low]=a[high];
        a[high]=temp;
    }
}
