package com.company.GFG.LinkList;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {
        Node n1=new Node(5,new Node(10,new Node(15,new Node(40 ))));
        Node n2=new Node(2,new Node(3,new Node(20)));
        Node h=sortedMerge(n1,n2);
        LinkListUtil.printList(h);
    }
    public static Node sortedMerge(Node headA, Node headB) {
        Node temp=null;
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        if(headA.data<headB.data){
            temp=headA;
            headA=headA.next;
        }else{
            temp=headB;
            headB=headB.next;
        }
        Node head=temp;
        while(headA!=null && headB!=null){
            if(headA.data<=headB.data){
                temp.next=headA;
                headA=headA.next;
            }else{
                temp.next=headB;
                headB=headB.next;
            }
            temp=temp.next;
        }
        if(headA!=null){
            temp.next=headA;
        }else {
            temp.next=headB;
        }
        return head;
    }
}
