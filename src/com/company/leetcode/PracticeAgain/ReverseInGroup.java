package com.company.leetcode.PracticeAgain;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.leetcode.ListNode;

public class ReverseInGroup {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode f = reverse(l1);
        LinkListUtil.printList(f);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = head, current = head.next, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = null;
        return prev;
    }
}
