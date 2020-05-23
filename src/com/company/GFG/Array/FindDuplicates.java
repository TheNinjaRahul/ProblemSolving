package com.company.GFG.Array;

public class FindDuplicates {
    public static void main(String[] args) {
        int data[]={1,2,3,1,2};
        printDuplicates(data,data.length);
        System.out.println();
    }
    public static void printDuplicates(int arr[], int n) {
        // Set<Integer> set=new HashSet<>();
        int [] result=new int[n];
        boolean result2 = false;
        for(int i=0;i<n;i++){
            result[arr[i]%n]=result[arr[i]%n]+1;
        }

        for(int i=0;i<n;i++){
            if(result[i]>1){
                result2=true;
                System.out.print(i+" ");
            }
        }
        if(!result2){
            System.out.print("-1");
        }
    }
}
