package com.company.leetcode.linklist;

import com.company.GFG.LinkList.ListNode;

public class LinkListCycleII {

    public static void main(String[] args) {
//        ListNode n = new ListNode(1);
//        ListNode n2=new ListNode(2);
//        ListNode n3 = new ListNode(3, new ListNode(4, new ListNode(5, n2)));
//        n.next = n2;
//        n2.next=n3;

        ListNode n = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        System.out.println(detectCycle(n).data);
    }

    public static ListNode detectCycle(ListNode head) {
        // if(1==1) return head.next;
        ListNode temp = head, fast = head;
        while (fast != null && fast.next != null) {
            temp = temp.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }

            if (temp == fast) {
                temp = head;
                while (temp != fast) {
                    temp = temp.next;
                    fast = fast.next;
                }
//                System.out.println(temp.data);
                return temp;
            }
        }
        return head;
    }
}
