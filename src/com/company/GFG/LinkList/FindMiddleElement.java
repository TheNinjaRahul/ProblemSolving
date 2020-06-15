package com.company.GFG.LinkList;

/**
 * Finding middle element in a linked list
 * Given a singly linked list of N nodes. The task is to find the middle of the linked list. For example, if given linked list is 1->2->3->4->5 then the output should be 3.
 * If there are even nodes, then there would be two middle nodes, we need to print the second middle element. For example, if given linked list is 1->2->3->4->5->6 then the output should be 4.
 * <p>
 * Input:
 * The first line of input contains the number of test cases T. For each test case, the first line of input contains the length of the linked list and the next line contains data of nodes of the linked list.
 * <p>
 * Output:
 * For each test case, there will be a single line of output containing data of the middle element of the linked list.
 * <p>
 * User Task:
 * The task is to complete the function getMiddle() which takes a head reference as the only argument and should return the data at the middle node of the linked list.
 * <p>
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * <p>
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 6
 * 2 4 6 7 5 1
 * <p>
 * Output:
 * 3
 * 7
 * <p>
 * Explanation:
 * Testcase 1: Since there are 5 elements, therefore 3 is the middle element at index 2 (0-based indexing).
 */
public class FindMiddleElement {
    public static void main(String[] args) {

    }

    public static int getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }
        return slow.data;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
    Node(int d,Node n) {
        data = d;
        next =n ;
    }
}
