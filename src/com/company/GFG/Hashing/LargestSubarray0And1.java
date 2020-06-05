package com.company.GFG.Hashing;

import java.util.HashMap;

public class LargestSubarray0And1 {
    public static void main(String[] args) {
        int a[]={0 ,0 ,1 ,0 ,0};

//        System.out.println(maxLen(a,a.length));
        int []b={1, 0, 1, 1, 1, 0, 0};
//        System.out.println(maxLen(b,b.length));
        int []c={0 ,1 ,0 ,1};
        System.out.println(maxLen(c,c.length));
    }
    static int maxLen(int[] a, int N)
    {
        int sum=0,startIndex=0,endIndex=-1,max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(a[i]==0){
                a[i]=-1;
            }

            sum+=a[i];

            if(sum==0){
                max=i+1;
                endIndex=i;
            }

            if(map.containsKey(sum+N)){
                if(max<(i-map.get(sum+N))){
                    max=i-map.get(sum+N);
                    endIndex=i;
                }
            }else {
                map.put(sum+N,i);
            }


        }
        startIndex=endIndex-max;
        System.out.println("index start from :"+startIndex+ " to :"+ endIndex);

        return max;
    }
}
