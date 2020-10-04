package com.company.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));


    }

    Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        while (!q.isEmpty() && (t - 3000) > q.peek()) {
            q.remove();
        }
        q.add(t);
        return q.size();
    }
}
