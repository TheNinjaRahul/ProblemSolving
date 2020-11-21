package com.company.leetcode.linklist;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.leetcode.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode f = addTwoNumbers(l1, l2);
        LinkListUtil.printList(f);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode prev = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                prev.val += s1.pop().val;
            }
            if (!s2.isEmpty()) {
                prev.val += s2.pop().val;
            }
            ListNode head = new ListNode(prev.val / 10);
            head.next = prev;
            prev.val = prev.val % 10;
            prev = head;
        }

        return prev.val == 0 ? prev.next : prev;
    }
}
