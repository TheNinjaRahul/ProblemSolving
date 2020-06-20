package com.company.GFG.LinkList;

public class ListNode {
    public int data;
    public ListNode next;

    public ListNode(int d) {
        data = d;
        next = null;
    }
    public ListNode(int d, ListNode n) {
        data = d;
        next =n ;
    }
}
