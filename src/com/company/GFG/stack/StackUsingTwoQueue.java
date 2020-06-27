package com.company.GFG.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackUsingTwoQueue {

    public static void main(String[] args) {

        Stack<Integer> mystack=new Stack<>();
                StackUsingTwoQueue s=new StackUsingTwoQueue();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.empty());
        System.out.println(s.pop());
        System.out.println(s.empty());
//        s.push(2);
//        System.out.println(s.pop());
//        System.out.println(s.empty());
    }
    Queue<Integer> q1=new LinkedList<Integer>();
    Queue<Integer> q2=new LinkedList<Integer>();
    int top=-1;
    public StackUsingTwoQueue() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top=x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        while(q1.size()>1){
            if(q1.size()==2){
                top=q1.peek();
            }
            q2.add(q1.remove());
        }

//        q2.add((q1.remove()));
//        q2.add((q1.remove()));
        int data=q1.remove();
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        return data;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}
