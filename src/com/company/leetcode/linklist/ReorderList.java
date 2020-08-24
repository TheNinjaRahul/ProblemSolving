package com.company.leetcode.linklist;

import com.company.leetcode.ListNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReorderList {
    public static void main(String[] args) {

    }

    public void reorderList(ListNode head) {
        LinkedList<ListNode> q = new LinkedList<>();
        ListNode t = head;
        while (t != null) {
            q.add(t);
            t = t.next;
        }
        if (q.size() == 1) return;

        ListNode l = null;

        while (q.size() != 0) {
            if (q.size() >= 2) {
                ListNode f = q.removeFirst();
                ListNode last = q.removeLast();
                if (l == null) {
                    f.next = last;
                    last.next = null;
                    l = last;
                } else {
                    l.next = f;
                    f.next = last;
                    last.next = null;
                    l = last;
                }
            } else if (q.size() == 1) {
                l.next = q.remove();
                l.next.next = null;

            }
        }
    }
}
