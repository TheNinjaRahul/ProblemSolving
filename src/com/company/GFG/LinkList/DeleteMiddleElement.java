package com.company.GFG.LinkList;

/**
 * Delete Middle of Linked List
 * Given a singly linked list, delete middle of the linked list. For example, if given linked list is 1->2->3->4->5 then linked list should be modified to 1->2->4->5.
 * If there are even nodes, then there would be two middle nodes, we need to delete the second middle element. For example, if given linked list is 1->2->3->4->5->6 then it should be modified to 1->2->3->5->6.
 * If the input linked list is NULL or has 1 node, then it should return NULL
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, there will be two lines of input, first of which contains the number of nodes in the linked list and next line contains elements in the nodes of the linked list.
 *
 * Output:
 * For each test case, print the modified linked list in a new line.
 *
 * User Task:
 * The task is to complete the function deleteMid() which should delete the middle element from the linked list and return the head of the modified linked list. If the linked list is empty then it should return NULL.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <= T <= 1000
 * 1 <= N <= 1000
 * 1 <= value <= 1000
 *
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 4 5
 * 6
 * 2 4 6 7 5 1
 *
 * Output:
 * 1 2 4 5
 * 2 4 6 5 1
 *
 * Explanation:
 * Testcase 1: After deleting the middle of the linked list, 3 will be deleted and the list will be as 1, 2, 4, 5.
 *
 */
public class DeleteMiddleElement {
    public static void main(String[] args) {

    }
    Node deleteMid(Node head) {
        Node prev=null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            prev=slow;
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }
        if(slow.next==null){
            prev.next=null;
        }else{
            prev.next=slow.next;
        }
        return head;
    }
}
