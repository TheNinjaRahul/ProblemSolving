package com.company.GFG.LinkList;

public class RearrangeEvenOdd {
    public static void main(String[] args) {
            Node h=new Node(1,new Node(2,new Node(3,new Node(4))));
            h=rearrangeEvenOdd(h);
            LinkListUtil.printList(h);

    }

    public static Node rearrangeEvenOdd(Node head)
    {
        Node odd=head,even=head.next,t1=head,t2=head.next;
        while(t1!=null && t2!=null && t1.next!=null && t2.next!=null){
            t1.next=t1.next.next;
            t2.next=t2.next.next;
            t1=t1.next;
            t2=t2.next;
        }

        t1.next=even;
        return odd;
    }


}
