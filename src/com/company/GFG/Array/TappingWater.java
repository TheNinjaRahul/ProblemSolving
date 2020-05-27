package com.company.GFG.Array;

public class TappingWater {
    public static void main(String[] args) {
        int data[]={7 ,4 ,0 ,9};
        int data2[] = {8, 8, 2, 4, 5, 5, 1};
        int data3[]={6,9,9};
        int data4[]={1,1,5,2,7,6,1,4,2,3};
        System.out.println("10="+tappingWater2(data));
        System.out.println("4="+tappingWater2(data2));
        System.out.println("0="+tappingWater2(data3));
        System.out.println(tappingWater2(data4));
    }


    public static int tappingWater2(int[] a) {
        int l=0,r=a.length-1,leftmax=Integer.MIN_VALUE,rightmax=Integer.MIN_VALUE;
        int sum=0;

        while(l<=r){
            if(a[l]<=a[r]){
                if(leftmax<a[l]){
                    leftmax=a[l++];
                }else{
                    sum+=leftmax-a[l++];
                }
            }else{
                if(rightmax<a[r]){
                    rightmax=a[r--];
                }else{
                    sum+=rightmax-a[r--];
                }
            }
        }

        return sum;


    }

    public static int tappingWater(int[] a) {
        int min[] = new int[a.length];
        int max[] = new int[a.length];
        min[0] = a[0];
        max[a.length - 1] = a[a.length - 1];
        int j = a.length - 2;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > min[i - 1]) {
                min[i] = a[i];
            } else {
                min[i] = min[i - 1];
            }
            if (a[j] > max[j + 1]) {
                max[j] = a[j];
            } else {
                max[j] = max[j + 1];
            }
            j--;
        }
        int sum = 0;
        for (int i = 1; i < a.length - 1; i++) {
            sum += Math.min(min[i], max[i]) - a[i];
        }
        return sum;
    }
}
