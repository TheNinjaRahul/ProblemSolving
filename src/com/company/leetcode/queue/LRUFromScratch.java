package com.company.leetcode.queue;

import java.util.HashMap;
import java.util.Map;

public class LRUFromScratch {

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.put(2, 1);
        System.out.println(lru.get(2));
        lru.put(3, 2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));
    }

    public LRUFromScratch(int capacity) {
        this.cap = capacity;
    }

    static class Node {
        int key, val;
        LRUFromScratch.Node next, prev;
    }

    static LRUFromScratch.Node f = null, l = null;
    static int cap = 0;
    static Map<Integer, LRUFromScratch.Node> map = new HashMap<>();

    // This method works in O(1)
    public int get(int key) {
        if (map.containsKey(key)) {
            LRUFromScratch.Node n = map.get(key);
            if (n.prev != null) {
                if (l == n) {
                    l = l.prev;
                }
                n.prev.next = n.next;

                if (n.next != null) {
                    n.next.prev = n.prev;
                }
                n.prev = null;
                f.prev = n;
                n.next = f;
                f = n;
            }
            return n.val;
        }


        return -1;
    }

    // This method works in O(1)
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            LRUFromScratch.Node n = map.get(key);
            n.val = value;

            if (n.prev != null) {
                if (l == n) {
                    l = l.prev;
                }
                n.prev.next = n.next;

                if (n.next != null) {
                    n.next.prev = n.prev;
                }
                n.prev = null;
                f.prev = n;
                n.next = f;
                f = n;

            }
        } else {

            LRUFromScratch.Node n = new LRUFromScratch.Node();
            n.val = value;
            n.key = key;
            if (map.size() < cap) {
                if (f != null) {
                    n.next = f;
                    f.prev = n;
                } else {
                    l = n;
                }
                f = n;
            } else {

                map.remove(l.key);
                if (l == f) {
                    l = null;
                    f = null;
                } else {
                    l = l.prev;
                    l.prev.next = null;
                }

                n.next = f;
                if (f != null) f.prev = n;
                f = n;
            }

            map.put(key, n);
        }

    }
}
