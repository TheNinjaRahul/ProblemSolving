package com.company.leetcode.queue;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {


    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
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

    static class MyNode {
        int key;
        int value;
        MyNode next, prev;

        public MyNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    MyNode first, last;
    Map<Integer, MyNode> map = new HashMap<>();
    int cap = 0;

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            MyNode n = map.get(key);
            removeNode(n);
            addAtFirst(n);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            removeNode(map.get(key));
            addAtFirst(map.get(key));
            map.get(key).value = value;
        } else if (map.size() < cap) {
            MyNode n = new MyNode(key, value);
            map.put(key, n);
            addAtFirst(n);
        } else {
            map.remove(last.key);
            removeNode(last);
            MyNode n = new MyNode(key, value);
            addAtFirst(n);
            map.put(key, n);
        }
    }

    public void removeNode(MyNode node) {
        if (first == last && first == node) {
            first = null;
            last = null;
        } else if (node == first) {
            first = first.next;
        } else if (node == last) {
            last = last.prev;
            last.next = null;
        } else {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }


    public void addAtFirst(MyNode node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            first.prev = node;
            node.next = first;
            first = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
