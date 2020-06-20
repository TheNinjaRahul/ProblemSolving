package com.company.GFG.LinkList;

public class GetNthNodeFromLinkList {
    public static void main(String[] args) {
        Node n1 = new Node(2, new Node(4, new Node(3,new Node(4,new Node(5)))));
        System.out.println(getNthFromLast(n1,5));
    }

    public static int getNthFromLast(Node head, int n)
    {
        if(head==null) return -1;
        Node temp=head,t2=head;
        int count=0;
        while(temp.next!=null && count<n){
            count++;
            temp=temp.next;
        }
        if(count==n-1) return head.data;
        if(count<n) return -1;

        while(temp!=null){
            t2=t2.next;
            temp=temp.next;
        }
        return t2.data;

    }
}
