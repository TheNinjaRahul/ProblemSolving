package com.company.GFG.Queue;

import java.util.HashMap;
import java.util.Map;

public class LRU {


    public static void main(String[] args) {
        LRU lru = new LRU(1);
       lru.set(2,1);
        System.out.println(lru.get(2));
        lru.set(3,2);
        System.out.println(lru.get(2));
        System.out.println(lru.get(3));


    }

    LRU(int cap) {
        this.cap = cap;
    }

    static class Node {
        int key, val;
        Node next, prev;
    }

    static Node f = null, l = null;
    static int cap = 0;
    static Map<Integer, Node> map = new HashMap<>();

    // This method works in O(1)
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            if (map.size() == 1 || f == n) {
                return n.val;
            }

            if (l == n) {
                l = l.prev;
                l.next = null;
            } else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            n.next = f;
            f.prev = n;
            f = n;
            f.prev = null;
            return f.val;
        }
        return -1;
    }

    // This method works in O(1)
    public void set(int key, int value) {

        if (map.containsKey(key)) {
            Node n = map.get(key);
            if (map.size() == 1) {
                n.val = value;
                return;
            }

            if (f == n) {
                f.val = value;
                return;
            } else if (l == n) {
                l = l.prev;
                l.next = null;
            } else {
                n.prev.next = n.next;
                n.next.prev = n.prev;
            }
            n.val = value;
            n.next = f;
            f.prev = n;
            f = n;
            f.prev = null;
            return;
        }
        if (f == null) {
            f = new Node();
            f.key = key;
            f.val = value;
            l = f;
            map.put(key, f);
        } else {
            Node n = new Node();
            n.val = value;
            n.key = key;
            n.next = f;
            f.prev = n;
            f = n;
            map.put(key, n);
        }

        if (map.size() == cap + 1) {
            map.remove(l.key);
            l = l.prev;
            l.next = null;
        }
    }
}
