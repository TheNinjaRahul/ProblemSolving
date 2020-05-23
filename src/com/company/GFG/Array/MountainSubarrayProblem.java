package com.company.GFG.Array;

public class MountainSubarrayProblem {
    public static void main(String[] args) {
        int []data={2 ,3 ,2 ,4 ,4 ,6 ,3 ,2};

        System.out.println(processQueries(data,0,2));
    }

    private static boolean processQueries(int[] data, int L, int R) {

        int[] left=new int[data.length];
        int[] right=new int[data.length];

        left[0]=data[0];
        int lastindex=0;
        right[data.length-1]=data[data.length-1];
        for(int i=1;i<data.length;i++){
            if(data[i]>data[i-1]){
                lastindex=i;
            }
            left[i]=lastindex;
        }
        lastindex=data.length-1;
        for(int i=data.length-2;i>=0;i--){
            if(data[i]>data[i+1]){
                lastindex=i;
            }
            right[i]=lastindex;
        }

        return right[L]>=left[R];

    }
}
