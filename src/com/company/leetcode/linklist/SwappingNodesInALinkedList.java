package com.company.leetcode.linklist;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.leetcode.ListNode;

public class SwappingNodesInALinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode ans = swapNodes(node, 2);
        LinkListUtil.printList(ans);
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode t1 = head, t2;

        int count = 1;
        while (t1 != null && count != k) {
            t1 = t1.next;
            count++;
        }

        ListNode temp1 = t1;
        t1 = t1.next;
        t2 = head;

        while (t1 != null) {
            t1 = t1.next;
            t2 = t2.next;
        }

        int tmep = temp1.val;
        temp1.val = t2.val;
        t2.val = tmep;


        return head;
    }
}
