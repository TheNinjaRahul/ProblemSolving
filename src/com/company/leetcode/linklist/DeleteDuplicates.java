package com.company.leetcode.linklist;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.leetcode.ListNode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode f = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3,
                new ListNode(4, new ListNode(4, new ListNode(5)))))));
        DeleteDuplicates d = new DeleteDuplicates();
        ListNode r = d.deleteDuplicates(f);
        LinkListUtil.printList(r);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = new ListNode(-1000);
        temp.next = head;

        ListNode t1 = head, prev = temp;

        while (t1 != null) {
            int val = t1.val;
            int count = 0;
            ListNode p = null;
            while (t1 != null && t1.val == val) {
                p = t1;
                t1 = t1.next;
                count++;
            }
            // System.out.println(t1.val+"->");
            if (count == 1) {
                prev.next = p;
                prev = p;
            }
        }
        return temp.next;
    }
}
