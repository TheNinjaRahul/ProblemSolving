package com.company.GFG.LinkList;

import java.util.List;

public class XORLinkList {

    public static void main(String[] args) {
        ListNode head=null;
        for(int i=0;i<5;i++){
            insertIntoList(head,i);
        }
    }

    private static void insertIntoList(ListNode head, int val) {
        ListNode n=new ListNode(val);
        if(head==null){
            head=n;
            return;
        }
        if(head.next==null){
//            n.next=(head^n);
        }
        ListNode temp=head,prev=head;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }




    }

}
