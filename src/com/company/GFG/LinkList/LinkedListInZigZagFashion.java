package com.company.GFG.LinkList;

public class LinkedListInZigZagFashion {

    public static void main(String[] args) {
        Node h=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5,new Node(6))))));
        zigzag(h);
        LinkListUtil.printList(h);
    }


    public static void zigzag(Node phead){
        if(phead==null || phead.next==null){
            return;
        }
       phead=mergeSort(phead);
       Node c=phead,n=phead.next;
        boolean f=true;
       while(c.next!=null){
           n=c.next;
           if(f){
               if(c.data>n.data){
                   int t=n.data;
                   n.data=c.data;
                   c.data=t;
               }
               f=!f;
           }else {
               if(c.data<n.data){
                   int t=n.data;
                   n.data=c.data;
                   c.data=t;
               }
               f=!f;
           }
           c=c.next;
       }
    }

    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }

        Node l2=slow.next;
        slow.next=null;
        Node l1=head;
        l1=mergeSort(l1);
        l2=mergeSort(l2);
        return sortedMerge(l1,l2);
    }

    static Node sortedMerge(Node headA, Node headB){
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
