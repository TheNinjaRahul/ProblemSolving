package com.company.GFG.LinkList;

public class MergeSort {
    public static void main(String[] args) {
        Node n1=new Node(50,new Node(10,new Node(1,new Node(4 ))));
        Node n2=new Node(2,new Node(3,new Node(20)));
        Node n=mergeSort(n1);
        LinkListUtil.printList(n);
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
