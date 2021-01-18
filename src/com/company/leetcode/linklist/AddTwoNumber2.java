package com.company.leetcode.linklist;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.leetcode.ListNode;

import java.util.LinkedList;
import java.util.Queue;

public class AddTwoNumber2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode ans = addTwoNumbers(l1, l2);
        LinkListUtil.printList(ans);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Queue<ListNode> s1 = new LinkedList<>();
        Queue<ListNode> s2 = new LinkedList<>();

        ListNode t = l1;
        while (t != null) {
            s1.add(t);
            t = t.next;
        }
        t = l2;
        while (t != null) {
            s2.add(t);
            t = t.next;
        }
        if (s1.size() == 0) return l2;
        if (s2.size() == 0) return l1;

        int cary = 0;
        Queue<ListNode> big;
        Queue<ListNode> small;
        if (s1.size() > s2.size()) {
            big = s1;
            small = s2;
        } else {
            big = s2;
            small = s1;
        }

        ListNode node = null;
        ListNode f = null;
        while (!big.isEmpty() && !small.isEmpty()) {
            node = big.remove();
            if (f == null) f = node;
            int val = cary + node.val + small.remove().val;
            cary = val / 10;
            val = val % 10;
            node.val = val;
        }

        while (cary != 0 && !big.isEmpty()) {
            node = big.remove();
            int val = cary + node.val;
            cary = val / 10;
            val = val % 10;
            node.val = val;
        }

        if (cary != 0) {
            ListNode l = new ListNode(cary);
            node.next = l;
//            l.next = node;
            return f;
        }
        return f;

    }
}
