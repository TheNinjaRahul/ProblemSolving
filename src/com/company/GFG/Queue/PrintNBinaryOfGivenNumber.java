package com.company.GFG.Queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PrintNBinaryOfGivenNumber {
    public static void main(String[] args) {
        Queue<String> q=new LinkedList<>();
        q.add("1");
        int n=5;
        while(n>0){
            String s=q.poll();
            System.out.println(s);
            q.add(s+"0");
            q.add(s+"1");
            n--;
        }
    }
}
