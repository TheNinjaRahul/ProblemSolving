package com.company.GFG.Array;

public class SticklerTheif {
    public static void main(String[] args) {
        int data[]={4,1,1,4,2,1};
        System.out.println(FindMaxSum(data,data.length));
    }
    public static int FindMaxSum(int a[], int n){
       int in=a[0],ex=0;

       for(int i=1;i<n;i++){
           int temp=in;
           if(ex+a[i]>in){
               in=ex+a[i];
               ex=temp;
           }else{
               ex=in;
           }
       }

       return Math.max(in,ex);



    }
}
