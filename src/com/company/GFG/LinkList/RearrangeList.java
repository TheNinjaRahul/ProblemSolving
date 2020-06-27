package com.company.GFG.LinkList;

/**
 * Reorder List
 * Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
 * For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.
 *
 * Note: It is recommended do this in-place without altering the nodes' values.
 *
 * Input:
 * First line of input contains number of testcases T. For each testcase, there will be two lines of input, first of which contains length of linked list and next line contains elements of the nodes of linked list.
 *
 * Output:
 * Reorder it as explained above.
 *
 * User Task:
 * The task is to complete the function reorderList() which should reorder the list as required.
 *
 * Note: Try to solve without using any auxilliary space.
 *
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= N <= 104
 *
 * Example:
 * Input:
 *
 * 2
 * 3
 * 1 2 3
 * 4
 * 1 7 3 4
 *
 * Output:
 * 1 3 2
 * 1 4 7 3
 *
 * Explanation:
 * Testcase 2: After rearranging the given list as required, we have list as 1 -> 4 -> 7 -> 3.
 */
public class RearrangeList {

    public static void main(String[] args) {
        Node n=new Node(1,new Node(2,new Node(3,new Node(4,new Node(5)))));
        n=reorderlist(n);
        LinkListUtil.printList(n);
    }


    static Node reorderlist(Node head) {
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }


        if(fast==null){
            fast=reverseList(slow);
        }else{
            fast=reverseList(slow.next);
        }

        slow=head;

        while(fast!=null){
            Node t=slow.next;
            slow.next=fast;
            Node t2=fast.next;
            fast.next=t;
            slow=t;
            fast=t2;
        }
        slow.next=null;
        return head;
    }

    public static Node reverseList(Node head) {
        Node prev, current, next;
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        prev = head;
        current = head.next;
        next = current.next;

        while (next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
        }
        current.next=prev;
        head.next = null;
        return current;

    }
}
