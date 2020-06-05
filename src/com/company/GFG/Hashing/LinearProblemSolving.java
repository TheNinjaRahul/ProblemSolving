package com.company.GFG.Hashing;

import java.util.Arrays;

public class LinearProblemSolving {
    public static void main(String[] args) {
        int data[]={0,4 ,14  ,24 ,44};
       int dataa2[]=linearProbing(10,data,data.length);
        System.out.println(Arrays.toString(dataa2));
    }

    static int[] linearProbing( int hash_size, int arr[], int N)
    {

        int hash[]=new int[hash_size];

        for(int i=0;i<hash_size;i++){
                hash[i]=-1;
        }
        int f=hash_size;
        for(int i=0;i<N;i++){
            int val=arr[i]%hash_size;
            if(f==0){
                return hash;
            }
            while(hash[val]!=-1){
                val=(val+1)%hash_size;
            }
            hash[val]=arr[i];
            f--;
        }



        return hash;

    }
}
