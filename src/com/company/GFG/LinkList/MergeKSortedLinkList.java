package com.company.GFG.LinkList;

/**
 * Merge K sorted linked lists
 * Given K sorted linked lists of different sizes. The task is to merge them in such a way that after merging they will be a single sorted linked list.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, first line of input contains number of linked lists N and next line contains data of nodes of all K linked lists, with first element as M, the length of linked list and next M elements for the same linked list.
 *
 * Output:
 * For each testcase, in a new line, print the merged linked list.
 *
 * Your Task:
 * The task is to complete the function mergeKList() which merges the K given lists into a sorted one. The printing is done automatically by the driver code.
 *
 * Expected Time Complexity: O(nk Logk)
 * Expected Auxiliary Space: O(k)
 *
 * Constraints
 * 1 <= T <= 50
 * 1 <= N <= 103
 *
 * Example:
 * Input:
 * 2
 * 4
 * 3 1 2 3 2 4 5 2 5 6 2 7 8
 * 3
 * 2 1 3 3 4 5 6 1 8
 * Output:
 * 1 2 3 4 5 5 6 7 8
 * 1 3 4 5 6 8
 *
 * Explanation :
 * Testcase 1: The test case has 4 sorted linked list of size 3, 2, 2, 2
 * 1st    list     1 -> 2-> 3
 * 2nd   list      4->5
 * 3rd    list      5->6
 * 4th    list      7->8
 * The merged list will be 1->2->3->4->5->5->6->7->8.
 * Testcase 2: The test case has 3 sorted linked list of size 2, 3, 1.
 * 1st list 1 -> 3
 * 2nd list 4 -> 5 -> 6
 * 3rd list 8
 * The merged list will be 1->3->4->5->6->8.
 */
public class MergeKSortedLinkList {
    public static void main(String[] args) {

    }

    static Node mergeKList(Node[]a,int N)
    {
        Node head=null;
        for(int i=0;i<a.length;i++){
            head=sortedMerge(head,a[i]);
        }
        return head;
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
