package com.company.GFG.Array;

public class MaxSumIntheConfiguration {
    public static void main(String[] args) {
        int []data={8,3,1,2};
        System.out.println(max_sum(data,data.length));
    }

    public static int max_sum(int A[],int n)
    {
        int result=0,mulValue=1,sum=0;
        for(int i=0;i<n;i++){
            mulValue*=A[i];
            sum+=A[i];
        }

        result=mulValue;
        for(int i=1;i<n;i++){
            int next_val =  - (sum -
                    A[i-1]) + A[i-1] *
                    (n-1);

            // Update current value
            mulValue = next_val;

            // Update result if required
            result = Math.max(result, next_val);
        }
        return result;
    }
}
