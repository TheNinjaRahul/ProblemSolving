package com.company.leetcode.array;

public class RotatedSortedArray {

    public static void main(String[] args) {
//        int[] data = {7, 0, 1, 2,4, 5, 6};
        int[] data = {1,3};
        System.out.println(search2(data, 3));

    }

    public static int search2(int[] nums, int target) {
        int mid=0, low=0,high=nums.length-1;

        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[low]<=nums[mid]){
                if(nums[mid]>target && nums[low]>target){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }else{
                if(target > nums[mid] && target <nums[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }

        return -1;
    }

    public static int search(int[] nums, int target) {

        if(nums.length==0){
            return -1;
        }

        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!(nums[i] <= nums[i + 1])) {
                pivot = i + 1;
                break;
            }
        }

        int low = 0, high = nums.length - 1, mid = (low + high) / 2;

        if (nums[(mid+pivot)%nums.length] == target) {
            return (mid+pivot)%nums.length;
        } else if (nums[(mid+pivot)%nums.length] > target) {
            return searchBinary(nums, target, low, mid - 1,pivot);
        } else {
            return searchBinary(nums, target, mid + 1, high,pivot);
        }

    }

    public static int searchBinary(int[] nums, int target, int low, int high,int pivot) {

        if (high >= low) {
            int mid = (low + high) / 2;
            if (low == -1 || high == nums.length) {
                return -1;
            }

            if (nums[(mid+pivot)%nums.length] == target) {
                return (mid+pivot)%nums.length;
            } else if (nums[(mid+pivot)%nums.length] > target) {
                return searchBinary(nums, target, low, mid - 1,pivot);
            } else {
                return searchBinary(nums, target, mid + 1, high,pivot);
            }
        } else {
            return -1;
        }
    }


}
