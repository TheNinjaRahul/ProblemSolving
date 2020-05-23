package com.company.GFG.Array;

public class ProductModulo {
    public static void main(String[] args) {

    }

    public static Long product(Long arr[], Long mod, int n)
    {
        Long l=1l;
        for(int i=0;i<n;i++){
            l=((arr[i])*(l))%mod;
        }
        return  (l%mod);
    }
}
