package com.company.GFG.Hashing;

import java.util.Arrays;

public class QuadraticProbingInHashing {
    public static void main(String[] args) {
        int data[]={21 ,10 ,32, 43};
        int[] hash=new int[11];
        Arrays.fill(hash,-1);
        quadraticProbing(hash,11,data,data.length);
        System.out.println(Arrays.toString(hash));
    }

    static void quadraticProbing(int[] hash, int hash_size, int arr[], int N) {
        int f = hash_size;
        for (int i = 0; i < N; i++) {
            int val = arr[i] % hash_size;
            if (f == 0) {
                return;
            }
            int j=1;
            int newcode=val;
            while (hash[val] != -1) {
                val= (int) (newcode + Math.pow(j,2))%hash_size;
                j++;
            }
            hash[val] = arr[i];
            f--;
        }
    }
}
