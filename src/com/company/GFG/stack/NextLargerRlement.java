package com.company.GFG.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerRlement {
    public static void main(String[] args) {
        long[] d= {1l,3l,2l,4l};
        System.out.println(Arrays.toString(nextLargerElement(d,3)));
    }

    public static long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> s=new Stack<>();
        long[] result=new long[arr.length];
        for(int i=arr.length-1;i>=0;i--){

            if(s.isEmpty()){
                result[i]=-1;
            }else if(s.peek()>arr[i]){
                result[i]=s.peek();
            }else{
                while(!s.isEmpty() && !(s.peek()>arr[i])){
                    s.pop();
                }
                if(s.isEmpty()){
                    result[i]=-1;
                }else{
                    result[i]=s.peek();
                }
            }
            s.push(arr[i]);
        }

        return result;
    }
}
