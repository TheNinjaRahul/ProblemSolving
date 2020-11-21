package com.company.GFG.LinkList;


public class LinkListUtil {
    public static void main(String[] args) {

    }

    public static void printList(Node head) {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            if (count++ == 100) return;
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            if (count++ == 100) return;
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public static void printList(com.company.leetcode.ListNode f) {
        com.company.leetcode.ListNode temp = f;
        int count = 0;
        while (temp != null) {
            if (count++ == 100) return;
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
    }
}

