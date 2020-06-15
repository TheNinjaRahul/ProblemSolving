package com.company.leetcode.linklist;

import com.company.GFG.LinkList.LinkListUtil;
import com.company.GFG.LinkList.ListNode;

public class RotateLinkList {
    public static void main(String[] args) {
        ListNode head=new ListNode(1,new ListNode(2,null));
        ListNode f=rotateRight(head,2);
        LinkListUtil.printList(f);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0) return head;

        ListNode temp=head;
        ListNode temp2=head;

        int i=0;
        while(true){
            if(temp==null){
                temp=head;
            }
            temp=temp.next;
            i++;
            if(i==k){
                break;
            }
        }
        if(temp==null) return head;
        while(temp.next!=null){
            temp2=temp2.next;
            temp=temp.next;
        }
        temp.next=head;
        head=temp2.next;
        temp2.next=null;
        return head;

    }
}
