package com.company.array;

public class ArrayManipulation {
    public static void main(String[] args) {
        int[][] q={{2,6,8},
                   {3,5,7},
                   {1,8,1},
                   {5,9,15}};
        System.out.println(arrayManipulation(10,q));
    }


    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] q) {
        long[] a=new long[n];
        long result=0;

        for(int i=0;i<q.length;i++){
            a[q[i][0]-1]+=q[i][2];
            if(q[i][1]<n){
                a[q[i][1]]-=q[i][2];
            }
        }

        for(int i=1;i<n;i++){

            a[i]=a[i]+a[i-1];
            if(result==0 && i==0){
                result=a[i];
            }
            else{
                if(result<a[i]){
                    result=a[i];
                }
            }
        }

        return result;

        /*for(int i=0;i<q.length;i++){
            for(int j=q[i][0]-1;j<q[i][1];j++){
                a[j]+=q[i][2];
                if(i==0 & result==0){
                    result=a[j];
                }else{
                    if(result<a[j]){
                        result=a[j];
                    }
                }
            }

            for(int k=0;k<a.length;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
        return result;*/
    }
}
