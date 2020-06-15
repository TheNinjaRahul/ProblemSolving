package com.company.GFG.LinkList;

import java.util.LinkedList;

public class RotateLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4,new Node(5)))));
        Node h = rotateRightLeetCode(head, 7);
        LinkListUtil.printList(h);
    }

    public static Node rotateRightLeetCode(Node head, int k) {
        Node temp=head;
        Node temp2=null;

        int i=1;
        while(true){
            if(temp==null){
                temp=head;
            }
            if(i==k){
                break;
            }
            temp=temp.next;
            i++;
        }

        temp2=temp;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head=temp2.next;
        temp2.next=null;
        return head;

    }

    public static Node rotateRight(Node head, int k) {
        Node temp=head;
        Node temp2=null;

        int i=1;
        while(temp.next!=null){
            if(i==k){
                break;
            }
            temp=temp.next;
            i++;
        }

        temp2=temp;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=head;
        head=temp2.next;
        temp2.next=null;
        return head;

    }

}
