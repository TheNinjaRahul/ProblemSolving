package com.company.leetcode.dp;

import java.util.Arrays;

public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] a) {
//
//        int dp[] = new int[a.length];
//        Arrays.fill(dp, -1);
//        return rec(a, 0, 0, dp);

         if(a.length==1 && a[0]==0) return 0;
         int stepCount=0;
         int currentJump=0;
         int maxJump=0;

         for(int i=0;i<a.length;i++){

             if(i==a.length-1) return stepCount;

             currentJump=Math.max(i+a[i],currentJump);
             if(i==maxJump){
                 stepCount++;
                 maxJump=currentJump;
             }
             // if(currentJump>=a.length-1) return stepCount+1;
         }
         return stepCount;


    }

    public static int rec(int[] a, int p, int jump, int[] dp) {
        if (p >= a.length) return 0;
        if (dp[p] != -1) return dp[p];

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= a[p]; i++) {
            ans = Math.min(ans, rec(a, i + p, 1 + jump, dp));
        }
        dp[p] = ans;
        return ans;
    }
}
