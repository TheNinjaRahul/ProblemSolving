package com.company.GFG.Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int data[]={1 ,5 ,4 ,3 };
        System.out.println(maxArea(data,data.length));
        int data2[]={3,1,2,4,5 };
        System.out.println(maxArea(data2,data2.length));
    }
    public static long maxArea(int A[], int len){
        // Code Here
        long result=0l;
        int p1=0,p2=len-1;

        while(p1<p2){
            if(A[p1]<A[p2]){
                if(result < A[p1]*(p2-p1)){
                    result=A[p1]*(p2-p1);
                }
                p1++;
            }else{
                if(result < A[p2]*(p2-p1)){
                    result=A[p2]*(p2-p1);
                }

                p2--;
            }
        }

        return result;
    }
}
