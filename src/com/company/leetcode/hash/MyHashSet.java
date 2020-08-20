package com.company.leetcode.hash;

import java.util.HashMap;
import java.util.Map;

public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        System.out.println(set.contains(1));
        System.out.println(set.contains(3));
        set.add(3);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set.contains(2));
    }

    class Node {
        int key;
        Node next;

        public Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    Node[] set = null;

    public MyHashSet() {
        set = new Node[1000 + 11];
    }

    public int hash(int key) {
        return key % set.length;
    }

    public void add(int key) {
        int hash = this.hash(key);
        if (set[hash] == null) {
            set[hash] = new Node(key, null);
            return;
        }
        Node temp = set[hash];
        while (temp.next != null && temp.key != key) {
            temp = temp.next;
            if (temp.key == key) {
                temp.key = key;
                return;
            }
        }

        if (temp.next == null) {
            temp.next = new Node(key, null);
        }

    }

    public void remove(int key) {
        int hash = this.hash(key);
        if (set[hash] == null) {
            return;
        }
        Node temp = set[hash];
        if (temp.key == key) {
            set[hash] = temp.next;
            return;
        }
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
            if (temp.key == key) {
                prev.next = temp.next;
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hash = this.hash(key);
        if (set[hash] == null) {
            return false;
        }
        Node temp = set[hash];
        if (temp.key == key) {
            return true;
        }
        Node prev = null;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
            if (temp.key == key) {
                return true;
            }
        }
        return false;
    }
}
