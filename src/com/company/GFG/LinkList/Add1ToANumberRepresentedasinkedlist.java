package com.company.GFG.LinkList;

/***
 * Add 1 to a number represented as linked list
 * A number (n) is represented in Linked List such that each digit corresponds to a node in linked list. You need to add 1 to it.
 *
 * Input:
 * The First line contains the number of test cases, and for each test case a single line of input denotes an integer n.
 *
 * Output:
 * For each test case, print the resulting number in a new line.
 *
 * User Task:
 * Your task is to complete the function addOne() which takes the head of the linked list as the only argument and returns the head of the modified linked list. The driver code prints the number and adds a new line.
 * Note: The head represents the left-most digit of the number.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(1).
 *
 * Constraints:
 * 1 <=T<= 100
 * 1 <=n<= 109
 *
 * Example:
 * Input:
 * 4
 * 456
 * 123
 * 999
 * 1879
 * Output:
 * 457
 * 124
 * 1000
 * 1880
 * Explanation:
 * 456 + 1 = 457
 * 123 + 1 = 124
 * 999 + 1 = 1000
 * 1879 + 1 = 1880
 */
public class Add1ToANumberRepresentedasinkedlist {
    public static void main(String[] args) {
        Node head = new Node(9, new Node(9, new Node(9, new Node(9))));
        Node f=addOne(head);
        LinkListUtil.printList(f);
    }

    public static Node addOne(Node head) {
        int carry = getSum(head.next);
        if (carry + head.data >= 10) {
            int result=(carry + head.data) / 10;
            head.data = (carry + head.data) % 10;
            Node n = new Node(result, head);
            return n;
        } else {
            head.data = (carry + head.data);
            return head;
        }
    }

    private static int getSum(Node head) {
        if (head == null) {
            return 1;
        }
        int carry = getSum(head.next);
        if (carry + head.data >= 10) {
            int result=(carry + head.data) / 10;
            head.data = (carry + head.data) % 10;
            return result;
        } else {
            head.data = (carry + head.data);
            return 0;
        }

    }
}
