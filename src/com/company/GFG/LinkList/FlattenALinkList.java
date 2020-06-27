package com.company.GFG.LinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Flattening a Linked List
 * Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
 * (i) a next pointer to the next node,
 * (ii) a bottom pointer to a linked list where this node is head.
 * <p>
 * You have to flatten the linked list to a single linked list which should be sorted.
 * <p>
 * 5 -> 10 -> 19 -> 28
 * |    |     |     |
 * V    V     V     V
 * 7    20    22    35
 * |          |     |
 * V          V     V
 * 8          50    40
 * |                |
 * V                V
 * 30               45
 * And after flattening the above list, the sorted linked list looks like:
 * <p>
 * 5-> 7-> 8- > 10 -> 19-> 20-> 22-> 28-> 30-> 35-> 40-> 45-> 50.
 * <p>
 * Note: The flattened list will be printed using the bottom pointer instead of next pointer.
 * <p>
 * Input:
 * The first line of the input contains an integer 'T' denoting the number of test cases. Then T test cases follow.
 * First line of each test case contains an integer N denoting the number of head nodes connected to each other.
 * Second line of each test case contains N space separated numbers (M1, M2...Mn) denoting number of elements in linked lists starting with each head.
 * Third line of each test case contains all the elements of the linked list starting with 1st head node and covering all the elements through its down pointer, then 2nd head node and covering all its elements through down pointer and so on till the last head node of the linked list.
 * <p>
 * Output:
 * For each testcase, in a new line, print the flattened list in sorted order.
 * <p>
 * Your Task:
 * This is a function problem. You need to complete the function flatten() that takes head of the list as parameter and returns the root of flattened list. The printing is done by the driver code.
 * <p>
 * Note: Try to solve the problem without using any extra space.
 * <p>
 * Expected Time Complexity: O(N*M)
 * Expected Auxiliary Space: O(1)
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 0 <= N <= 50
 * 1 <= Mi <= 20
 * 1 <= Element of linked list <= 103
 * <p>
 * Example:
 * Input:
 * 1
 * 4
 * 4 2 3 4
 * 5 7 8 30 10 20 19 22 50 28 35 40 45
 * <p>
 * Output:
 * 5 7 8 10 19 20 22 28 30 35 40 45 50
 */
public class FlattenALinkList {

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(330);
        Node n4 = new Node(10);
        Node n5 = new Node(11);
        Node n6 = new Node(12);
        Node n7 = new Node(13);
        Node n8 = new Node(20);
        Node n9 = new Node(21);
        n0.next=n1;
        n1.next = n4;
        n4.next = n8;
        n1.bottom = n2;
        n2.bottom = n3;

        n4.bottom = n5;
        n5.bottom = n6;
        n6.bottom = n7;

        n8.bottom = n9;

        Node f = flatten(n0);

        int i = 0;
        while (f != null) {
            if (i++ == 20) break;
            System.out.print(f.data + "->");
            f = f.bottom;
        }
    }

    public static Node flatten(Node root) {
        Node head = root;
        while (root != null) {
            root = sortedMerge(root, root.next);
            root = root.next;
        }
        return head;

    }

    static Node sortedMerge(Node headA, Node headB) {
        Node temp = null;
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }
        if (headA.data <= headB.data) {
            temp = headA;
            headA = headA.bottom;
        } else {
            temp = headB;
            headB = headB.bottom;
        }
        Node head = temp;
        while (headA != null && headB != null) {
            if (headA.data <= headB.data) {
                temp.bottom = headA;
                headA = headA.bottom;
            } else {
                temp.bottom = headB;
                headB = headB.bottom;
            }
            temp = temp.bottom;
        }
        while (headA != null) {
            temp.bottom = headA;
            temp = temp.bottom;
            headA = headA.bottom;
        }
        while (headB != null) {
            temp.bottom = headB;
            temp = temp.bottom;
            headB = headB.bottom;
        }
        return head;
    }

//    private static Node merge(Node head, Node root) {
//        if(root==null) return head;
//        Node t1=head;
//        Node t2=root;
//        while(t1!=null && t2!=null){
//
//        }
//
//    }

    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }
}
