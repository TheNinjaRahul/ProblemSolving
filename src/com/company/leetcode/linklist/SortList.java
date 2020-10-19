package com.company.leetcode.linklist;

import com.company.leetcode.ListNode;

public class SortList {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(10, new ListNode(0)))));
        SortList s = new SortList();
        /*ListNode data = s.sortList(head);
        while (data != null) {
            System.out.print(data.val + " ");
            data = data.next;
        }*/
        ListNode head2 = new ListNode(-1, new ListNode(-2, new ListNode(-3, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1)))))));
        ListNode data = s.sortList(head2);
        while (data != null) {
            System.out.print(data.val + " ");
            data = data.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head, slow = head, fast = head;

        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;

        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }

        ListNode temp = head;


        while (left != null && right != null) {
            if (left.val < right.val) {
                head.next = left;
                left = left.next;
            } else {
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        while (left != null) {
            head.next = left;
            head = head.next;
            left = left.next;
        }

        while (right != null) {
            head.next = right;
            head = head.next;
            right = right.next;
        }

        return temp;
    }
}
