package com.company.leetcode.amazonOnline;

import com.company.leetcode.ListNode;

public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode r = reverseBetween(l, 2, 4);
        while (r != null) {
            System.out.print(r.val + "->");
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        int j = 1;
        ListNode beforeStartM = null, afterEndN = head, t1 = head, t2 = head;

        // int count=0;
        while (i != m || j != n) {
            if (i < m) {
                beforeStartM = t1;
                t1 = t1.next;
                System.out.println("Inside t1=" + t1.val);
            }
            if (j < n) {
                t2 = t2.next;
                afterEndN = t2.next;
            }
            i++;
            j++;
            if (j == n) break;
        }
        System.out.println("Point 1" + t1.val);
        System.out.println("Point 2" + t2.val);
        t2.next = null;
        ListNode h = reverseList(t1);
        t1.next = afterEndN;
        if (beforeStartM != null) {
            beforeStartM.next = h;
        } else {
            return t2;
        }
        return head;
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode h = head;
        ListNode p = head;
        ListNode c = head.next;
        ListNode n = c.next;
        while (n != null) {
            c.next = p;
            p = c;
            c = n;
            n = c.next;
        }
        c.next = p;
        head.next = null;
        return c;
    }

}
