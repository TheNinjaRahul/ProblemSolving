package com.company.GFG.stack;

import java.util.Stack;

public class DeleteMiddleElementFromStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        System.out.println(deleteMid(s,s.size(),0));

    }

    public static Stack<Integer> deleteMid(Stack<Integer>s,int sizeOfStack,int current)
    {
        if(s.isEmpty()){
            return s;
        }
        int temp=s.pop();
        s = deleteMid(s,sizeOfStack,current+1);
        if(current==sizeOfStack/2) return s;

        s.push(temp);
        return s;

    }
}
