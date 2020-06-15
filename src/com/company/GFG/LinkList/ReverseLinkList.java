package com.company.GFG.LinkList;

/***
 * Reverse a linked list
 * Given a linked list of N nodes. The task is to reverse this list.
 *
 * Input: Head of following linked list
 * 1->2->3->4->NULL
 * Output: Linked list should be changed to,
 * 4->3->2->1->NULL
 *
 * Input: Head of following linked list
 * 1->2->3->4->5->NULL
 * Output: Linked list should be changed to,
 * 5->4->3->2->1->NULL
 *
 * Input: 1->NULL
 * Output: 1->NULL
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, the first line contains the length of the linked list and the next line contains the elements of the linked list.
 *
 * Output:
 * For each test case, print the reversed linked list in a new line.
 *
 * User Task:
 * The task is to complete the function reverseList() with head reference as the only argument and should return new head after reversing the list.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 104
 *
 * Example:
 * Input:
 * 2
 * 6
 * 1 2 3 4 5 6
 * 5
 * 2 7 8 9 10
 * Output:
 * 6 5 4 3 2 1
 * 10 9 8 7 2
 *
 * Explanation:
 * Testcase 1: After reversing the list, elements are 6->5->4->3->2->1.
 * Testcase 2: After reversing the list, elements are 10->9->8->7->2.
 */


public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode r = reverseList(head);
        LinkListUtil.printList(r);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev, current, next;
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
