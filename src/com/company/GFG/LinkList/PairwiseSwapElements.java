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
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
//        Node f = pairwiseSwap(head);
        Node f = pairSwap(head);
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
        {
            Node prev, current, next;
            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return head;
            }

            Node result = head;
            int ik = 1;
            while (ik != k) {
                result = result.next;
                ik++;
            }

            prev = head;
            current = head.next;
            next = current.next;

            while (current != null) {
                int i = 1;
                Node last = prev;
                while (current != null && i != k) {
                    i++;
                    current.next = prev;
                    prev = current;
                    current = next;
                    if (next == null) {
                        break;
                    }
                    next = next.next;
                }
                i = 1;
                if (current == null) {
                    last.next = null;
                    break;
                }
                Node temp = current;
                while (i < k) {
                    i++;
                    if (temp.next == null) {
                        temp = current;
                        break;
                    }
                    temp = temp.next;
                }
                if (temp == current) {
                    last.next = current;
                    break;
                }
                last.next = temp;
                prev = current;
                current = current.next;
                next = current.next;
            }

            return result;
        }


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
