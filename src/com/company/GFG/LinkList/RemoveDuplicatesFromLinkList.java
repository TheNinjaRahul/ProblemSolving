package com.company.GFG.LinkList;


import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Given an unsorted linked list of N nodes. The task is to remove duplicate elements from this unsorted Linked List. If all the nodes in the linked list are equal, then remove n-1 nodes.
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, the first line of input contains a number of nodes in the linked list, and the next line contains node data for N nodes.
 *
 * Output:
 * For each test case, print the linked list with no repeating elements.
 *
 * User Task:
 * You have to complete the method removeDuplicates() which takes 1 argument: the head of the linked list. You should not read any input from the stdin/console. Your function should return a pointer to a linked list with no duplicate element.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= size of linked lists <= 104
 * 1 <= numbers in list <= 104
 *
 * Example:
 * Input:
 * 2
 * 4
 * 5 2 2 4
 * 5
 * 2 2 2 2 2
 * Output:
 * 5 2 4
 * 2
 *
 * Explanation:
 * Testcase 1: Given linked list elements are 5->2->2->4, in which 2 is repeated only. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain 5->2->4.
 * Testcase 2: Given linked list elements are 2->2->2->2->2, in which 2 is repeated. So, we will delete the extra repeated elements 2 from the linked list and the resultant linked list will contain only 2.
 */
public class RemoveDuplicatesFromLinkList {
    public static void main(String[] args) {

    }
    public Node removeDuplicates(Node head)
    {
        if(head==null) return null;
        if(head.next==null) return head;

        Set<Integer> set=new LinkedHashSet<>();
        Node t=head;
        while(t!=null){
            set.add(t.data);
            t=t.next;
        }
        t=null;
        Iterator<Integer> iterator=set.iterator();
        while(iterator.hasNext()){
            if(t==null){
                t=new Node(iterator.next());
                head=t;
            }else{
                int n=iterator.next();
                t.next=new Node(n);
                t=t.next;
            }
        }
        return head;
    }
}
