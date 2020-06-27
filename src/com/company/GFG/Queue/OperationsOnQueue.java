package com.company.GFG.Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class OperationsOnQueue {

    Queue<Integer> q=new ArrayDeque<>();

    void enqueue(int x){

    }
    void dequeue(){
        q.remove();
    }
    int front(){
        if(q.isEmpty()) return -1;
        return q.poll();
    }
    String find(int x){
        for(Integer i:q){
            if(i==x){
                return "Yes";
            }
        }
        return "No" ;
    }
}
