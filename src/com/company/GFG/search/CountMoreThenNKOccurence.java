package com.company.GFG.search;

import java.util.Arrays;

public class CountMoreThenNKOccurence {
    public static void main(String[] args) {
        int []data={3 ,1 ,2 ,2 ,1 ,2 ,3 ,3};
        System.out.println(countOccurence(data,data.length,4));
    }

    public static int countOccurence(int[] a, int n, int k) {
        int innercount=1,result=0;
        Arrays.sort(a);

        for(int i=1;i<a.length;i++){
            if(a[i]==a[i-1]){
                innercount++;
            }else{
                if(innercount>(n/k)){
                    result++;
                }
                innercount=1;
            }
        }

        return innercount>(n/k) ? result+1 : result;
    }
}
