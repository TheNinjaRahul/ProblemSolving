package com.company.GFG.Array;

public class InversionOfArray {
    public static void main(String[] args) {
        int[] data={2 ,4 ,1 ,3 ,5};
        System.out.println(inversionCount(data,data.length));
    }

    public static int inversionCount(int  a[],  int N)
    {
        int [] my=new int[N];
        int j=0;
        my[j]=a[0];
        int count=0;
        for(int i=1;i<N;i++){

            if(a[i]>a[j]){
                a[++j]=a[i];
            }else{
                count++;
            }
        }
        return count;

    }
}
