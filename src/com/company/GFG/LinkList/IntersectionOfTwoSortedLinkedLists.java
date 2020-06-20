package com.company.GFG.LinkList;

/**
 * Intersection of two Sorted Linked Lists
 * Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed.
 * Example:
 *
 * Input:
 * First linked list: 1->2->3->4->6
 * Second linked list be 2->4->6->8,
 * Output: 2->4->6.
 * The elements 2, 4, 6 are common in
 * both the list so they appear in the
 * intersection list.
 *
 * https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 */
public class IntersectionOfTwoSortedLinkedLists {

    public static void main(String[] args) {

    }

    public static Node findIntersection(Node headA, Node headB)
    {
        Node head=null;
        Node t1=headA,t2=headB,t3=null;
        while (t1!=null && t2!=null)
        {
            if(t1.data!=t2.data){
                if(t1.data<t2.data){
                    t1=t1.next;
                }else{
                    t2=t2.next;
                }
            }else{
                if(t3==null){
                    t3=new Node(t1.data);
                    head=t3;
                }else{
                    t3.next=new Node(t1.data);
                    t3=t3.next;
                }
                t1=t1.next;
                t2=t2.next;
            }
        }
        return head;
    }
}
