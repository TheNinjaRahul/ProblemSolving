package com.company.leetcode.linklist;

import com.company.leetcode.ListNode;

public class RemoveLinkListNode {

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(1));
        removeElements(root, 1);
    }

    public static ListNode removeElements(ListNode head, int k) {
        while (head != null && head.val == k) {
            head = head.next;
        }
        if (head == null) return head;

        if (head.val == k && head.next == null) return head.next;
        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (current.val == k) {
                prev.next = current.next;
                current = current.next;
                continue;
            }
            prev = current;
            current = current.next;
        }

        return head;

    }
}
