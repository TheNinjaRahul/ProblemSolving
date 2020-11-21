package com.company.leetcode.amazonOnline;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));
        lru.put(4, 4);
        System.out.println(lru.get(1));
        System.out.println(lru.get(3));
        System.out.println(lru.get(4));
    }

    static class Node {
        int key;
        int val;
        Node prev, next;
    }

    int cap = 0;
    Node first = null, last = null;
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            removeFromList(n);
            addToFirst(n);
            return n.val;
        } else {
            return -1;
        }
    }

    private void addToFirst(Node n) {
        if (first == null) {
            first = n;
            last = n;
        } else {
            n.next = first;
            first.prev = n;
            first = n;
            n.prev = null;
        }
    }

    private void removeFromList(Node n) {
        if (first == last && first == n) {
            first = null;
            last = null;
        } else if (n == first) {
            first = n.next;
        } else if (n == last) {
            last = last.prev;
            last.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    public void put(int key, int value) {
        Node n = null;
        if (map.containsKey(key)) {
            n = map.get(key);
            n.val = value;
            removeFromList(n);
        } else {
            if (map.size() == cap) {
                map.remove(last.key);
                removeFromList(last);
            }
            n = new Node();
            n.val = value;
            n.key = key;
        }
        addToFirst(n);
        map.put(n.key, n);
    }

    private void deleteLast() {
        Node n = last;
        last = n.prev;
        last.next = null;
        map.remove(n.key);
    }
}
