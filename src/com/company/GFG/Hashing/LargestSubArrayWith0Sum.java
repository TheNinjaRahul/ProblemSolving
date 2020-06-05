package com.company.GFG.Hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {
    public static void main(String[] args) {
        int a[]={15,-2,2,-8,1,7,10,23};
//        System.out.println(maxLen(a,0));
        int b[]={-1, 1 ,-1 ,1};
        System.out.println(maxLen(b,0));
    }


    static int maxLen(int a[], int n) {
        n=a.length;
        int start=0,end=-1,sum=0,maxlength=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=a[i];

            if(sum==0){
                maxlength=i+1;
                end=i;
            }
            if(map.containsKey(sum)){
                if(maxlength<i-(map.get(sum))){
                    maxlength=i- map.get(sum);
                    end=i;
                }
            }else {
                map.put(sum,i);
            }
        }
        start=end-maxlength+1;
        System.out.println("starting index is:"+start);
        System.out.println("starting index is:"+end);
        return maxlength;


    }
}
