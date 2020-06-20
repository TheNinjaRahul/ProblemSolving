package com.company.GFG.LinkList;

/**
 * Pairwise swap elements of a linked list
 * Given a singly linked list of size N. The task is to swap elements in the linked list pairwise.
 * For example, if the input list is 1 2 3 4, the resulting list after swaps will be 2 1 4 3.
 * <p>
 * Input:
 * The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the linked list and the next line contains linked list data.
 * <p>
 * Output:
 * Output the linked list after swapping pairwise nodes.
 * <p>
 * User Task:
 * The task is to complete the function pairWiseSwap() which takes the head node as the only argument and returns the modified head.
 * <p>
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 103
 * <p>
 * Example:
 * Input:
 * 1
 * 8
 * 1 2 2 4 5 6 7 8
 * <p>
 * Output:
 * 2 1 4 2 6 5 8 7
 * <p>
 * Explanation:
 * Testcase 1: After swapping each pair considering (1,2), (2, 4), (5, 6).. so on as pairs, we get 2, 1, 4, 2, 6, 5, 8, 7 as a new linked list.
 */
public class PairwiseSwapElements {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5,new Node(6,new Node(7)))))));
//        Node f = rev(head);
        Node f = reverseKNode(head,3);
        LinkListUtil.printList(f);
    }


    public static Node pairSwap(Node head){

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        Node d=new Node(-1);

        Node result=head.next;
        d.next=head;
        Node p,q;
        while(d.next!=null && d.next.next!=null){
            p=d.next;
            q=p.next;

            d.next=q;
            p.next=q.next;
            q.next=p;
            d=p;
        }
        return result;
    }

    public static Node reverseKNode(Node head, int k) {
        if(head==null || head.next==null) return head;

        Node res=null,last=null;
        Node temp=head;
        while(temp!=null){
            int i=0;
            Node t1=temp,p=null;
            while(i<k && t1!=null){
                p=t1;
                t1=t1.next;
                i++;
            }
            p.next=null;
            Node rev=reverseLinkList(temp);
            temp=t1;
            if(res==null){
                res=rev;
                last=rev;
            }else{
                last.next=rev;
            }
            while(last.next!=null) last=last.next;
        }
        return res;
    }

    private static Node reverseLinkList(Node t1) {
        if(t1==null || t1.next==null) return t1;
        Node t=t1;
        Node p=t;
        Node c=p.next;
        if(c.next==null){
            c.next=p;
            p.next=null;
            return c;
        }
        Node n=c.next;

        while (c.next!=null){
            c.next=p;
            p=c;
            c=n;
            n=n.next;
        }
        c.next=p;
        t1.next=null;
        return c;

    }

    public static Node pairwiseSwap(Node head) {
        if (head == null || head.next == null) return head;
        Node current, prev, next, last;
        prev = head;
        head = head.next;
        current = prev.next;
        next = current.next;

        while (current != null && next != null) {
            last = current;
            current = prev;
            last = prev;
            prev = next;

            current = prev.next;
            next = current.next;
        }

        return head;


    }
}
