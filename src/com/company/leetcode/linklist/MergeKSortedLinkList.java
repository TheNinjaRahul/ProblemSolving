package com.company.leetcode.linklist;

import com.company.leetcode.ListNode;

public class MergeKSortedLinkList {

    public static void main(String[] args) {
//        int[] data = {1, 2, 3};
////        ListNode first = new ListNode[]{new ListNode(1, new ListNode(2,
////                new ListNode(3, new ListNode(4, null))));
        ListNode[] list = new ListNode[]{new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null)))),
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))))};

        ListNode m = mergeKLists(list);

        while (m != null) {
            System.out.print(" " + m.val);
            m = m.next;
        }


    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode first = null;
        for (int i = 0; i < lists.length; i++) {
            first = mergeTwoLists(lists[i], first);
        }

        return first;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        temp.next = l1 == null ? l2 : l1;
        return head;
    }
}
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}



