package com.company.leetcode.linklist;

import com.company.leetcode.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkedListRandomNode {


    Map<Integer, ListNode> map;
    Random rand;// = new Random();

    // Generate random integers in range 0 to 999
    // int rand_int1 = rand.nextInt(1000);
    public LinkedListRandomNode(ListNode head) {
        rand = new Random();
        map = new HashMap<>();
        ListNode t1 = head;
        int i = 0;
        while (t1 != null) {
            map.put(0, t1);
            t1 = t1.next;
        }
    }

    public static void main(String[] args) {
        LinkedListRandomNode l = new LinkedListRandomNode(null);
        for (int i = 0; i < 5; i++) {
            System.out.println(l.rand.nextInt(1000));
        }
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        int i = rand.nextInt(map.size());
        return map.get(i).val;
    }

}
