package com.company.GFG.search;

public class FindPeakElement {
    public static void main(String[] args) {

        int data[] = {5, 10, 11, 12,13,14};
//        System.out.println(findPeakElement(data,data.length));
        int data2[] = {1,2,3};
//        System.out.println(findPeakElement(data2,data2.length));
        int data3[] = {1};
        System.out.println(findPeakElement(data3,data3.length));
    }

    public static int findPeakElement(int data[],int n) {


        if(n==1){
            return 0;
        }
        int start = 0, end = data.length, mid = 0, ans = 0;

        while (start <= end) {

            mid = (start + end) / 2;
            // System.out.println(mid);
            if(mid==0){
                if(data[0]>data[1]){
                    return 0;
                }else{
                    return 1;
                }
            }
            if(mid==n-1){
                if(data[n-1]>data[n-2]){
                    return n-1;
                }else{
                    return n-2;
                }
            }
            if ((data[mid] > data[mid - 1]) && (data[mid] > data[mid + 1]) ) {
                return mid;
            } else if (data[mid] < data[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return 1;


    }
}
