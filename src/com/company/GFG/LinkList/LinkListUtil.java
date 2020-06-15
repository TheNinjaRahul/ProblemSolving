package com.company.GFG.LinkList;


public class LinkListUtil {
    public static void main(String[] args) {

    }

    public static void  printList(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
    public static void  printList(ListNode head){
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
    }
}

