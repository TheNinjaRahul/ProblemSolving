package com.company.leetcode;

import java.util.List;

public class MergeTwoSortedLinkList {

    public static void main(String[] args) {

        ListNode l1=new ListNode(2,null); //new ListNode(2,new ListNode(4,null)));
        ListNode l2=new ListNode(1,null );//new ListNode(3,new ListNode(4,null)));

        ListNode m=mergeTwoLists(l1,l2);

        while(m!=null){
            System.out.print(" "+m.val);
            m=m.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode head;
        if(l1.val<=l2.val){
            head=l1;
            l1=l1.next;
        }else{
            head=l2;
            l2=l2.next;
        }
        ListNode temp=head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
                temp=temp.next;
            }else{
                temp.next=l2;
                l2=l2.next;
                temp=temp.next;
            }
        }

        temp.next = l1==null ? l2 : l1;

        return  head;
    }
}
