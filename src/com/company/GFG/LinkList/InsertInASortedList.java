package com.company.GFG.LinkList;

/***
 * Insert in a Sorted List
 * Given a sorted singly linked list and a data, your task is to insert the data in the linked list in a sorted way i.e. order of the list doesn't change.
 *
 * Input:
 * The function takes 2 arguments as input, reference pointer to the head of the sorted single linked list and an integer data value which is to be inserted in the list.
 * There are multiple test cases and for each test case, the function will be called separately.
 *
 * Output:
 * For each test, the output will be space-separated integers denoting the values of the linked list.
 *
 * User Task:
 * The task is to complete the function sortedInsert() which should insert the element in sorted Linked List.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 104
 * -99999 <= A[i] <= 99999, for each valid i
 *
 * Example:
 * Input:
 * 2
 * 6
 * 25 36 47 58 69 80
 * 19
 * 2
 * 50 100
 * 75
 *
 * Output:
 * 19 25 36 47 58 69 80
 * 50 75 100
 *
 * Explanation:
 * Testcase 1: After inserting 19 at particular place, the linked list is like 19, 25, 36, 47, 58, 69, 80.
 *
 */
public class InsertInASortedList {
    public static void main(String[] args) {
//        1 10 21 32 38
        Node head = new Node(1, new Node(10, new Node(21, new Node(32))));
        head = sortedInsert(head, 1);
        LinkListUtil.printList(head);
    }

    public static Node sortedInsert(Node head1, int key) {

        Node n = new Node(key);
        Node temp = head1, prev = null;
        if (head1 == null) {
            return n;
        }

        if (key <= head1.data) {
            n.next = head1;
            return n;
        }
        while (temp != null && temp.data < key) {
            prev = temp;
            temp = temp.next;
        }
        n.next = temp;
        prev.next = n;
        return head1;
    }
}
