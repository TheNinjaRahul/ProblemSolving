package com.company.leetcode;

import java.util.ArrayList;
import java.util.Random;

public class RandomPickWithWeight {



    public static void main(String[] args) {
        RandomPickWithWeight obj=new RandomPickWithWeight();
        int data[]={1};
        obj.Solution(data);
        System.out.println(obj.pickIndex());
    }

    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<Integer> input = new ArrayList<>();
    Random rand = new Random();

    public void Solution(int[] w) {
        int sum = 0;
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            input.add(w[i]);
            list.add(sum);
        }
    }

    public int pickIndex() {
        int i = new Random().nextInt(list.get(list.size()-1))+1;
        int start = 0;
        int end = list.size()-1;
        while(start<=end) {
            int mid = end+(start-end)/2;
            if(list.get(mid)==i) {
                return mid;
            } else if(list.get(mid)<i){
                start=mid+1;
            } else {
                end=mid-1;
            }
        }
        return  start;
    }

}
