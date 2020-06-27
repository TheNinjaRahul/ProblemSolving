package com.company.GFG.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElementsOfQueue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println(modifyQueue(q, 3));
    }

    public static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        int n = q.size();
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < n) {
            s.push(q.remove());
            if (s.size() == k) {
                while (s.size() != 0) {
                    q.add(s.pop());
                }
                break;
            }
            i++;
        }

        Queue<Integer> s2 = new LinkedList<>();
        while (i < n-1) {
            s2.add(q.remove());
            i++;
        }
        while (s2.size() != 0) {
            q.add(s2.remove());
        }

        return q;
    }
}
