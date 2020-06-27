package com.company.GFG.LinkList;

import org.omg.CORBA.INTERNAL;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfLinkList {
    public static void main(String[] args) {
        Node n=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        Node n1=new Node(2, new Node(4,new Node(5,new Node(10,new Node(20)))));

        n=findIntersection(n,n1);
        LinkListUtil.printList(n);
    }

    public static Node findIntersection(Node head1,  Node head2)
    {
        Set<Integer> set=new HashSet<>();
        Node t=head1;
        while(t!=null){
            set.add(t.data);
            t=t.next;
        }

        Node head=null,temp=null;
        t=head2;
        while(t!=null){
            if(set.contains(t.data)){
                if(head==null){
                    Node n=new Node(t.data);
                    head=n;
                    temp=n;

                }else{
                    temp.next=new Node(t.data);
                    temp=temp.next;
                }
            }
            t=t.next;
        }

        return head;

    }
}
