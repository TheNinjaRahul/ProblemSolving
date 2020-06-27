package com.company.leetcode.stack;

import javax.management.ObjectName;
import java.util.Stack;

public class OnlineSpan {
    public static void main(String[] args) {
//        int data[]={100,80,60,70,60,75,85};
        int data[]={90,21,21,68,94,13,1,37,3,61,86,19,12,35,96};
        OnlineSpan o=new OnlineSpan();
        for(int i=0;i<data.length;i++){
            System.out.print(o.next(data[i]) +" ");
        }
    }

    public OnlineSpan() {

    }

    class myclass{
        int i;
        int val;

        public myclass(int i, int val) {
            this.i = i;
            this.val = val;
        }
    }
    Stack<myclass> s = new Stack<myclass>();
    int i=0;
    public int next(int price) {
        myclass e=new myclass(i,price);
        int result=1;
        if (s.isEmpty()) {
            s.push(e);
            result= 1;
        } /*else if (s.peek().val >= price) {
            result=i-s.peek().i;
            s.push(e); }*/
        else {
            while (!s.isEmpty() && (s.peek().val <= price)) {
                s.pop();
            }

            if (s.isEmpty()) {
                result=i+1;
            } else {
                result=i-s.peek().i;
            }
        }
        s.push(e);
        i++;
        return result;
    }
}
