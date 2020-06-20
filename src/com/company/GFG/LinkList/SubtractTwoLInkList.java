package com.company.GFG.LinkList;

/**
 * Subtraction in Linked List
 * Given two linked lists that represent two large positive numbers. The task is to subtract the given two numbers represented by the linked list. Subtract the smaller from the larger one.
 * <p>
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case contains an integer N denoting the size of the first linked list (L1)  In the next line are the space-separated values of the first linked list. The third line of each test case contains an integer M denoting the size of the second linked list (L2). In the fourth line are space-separated values of the second linked list.
 * <p>
 * Output:
 * For each test case, the output will be space-separated values of the resultant linked list.
 * <p>
 * User Task:
 * The task is to complete the function subLinkedList() which should subtract the numbers represented by the linked list.
 * <p>
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(N).
 * <p>
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N, M <= 10000
 * <p>
 * Example:
 * Input:
 * 1
 * 3
 * 1 0 0
 * 2
 * 1 2
 * <p>
 * Output:
 * 8 8
 * <p>
 * Explanation:
 * Testcase 1: 12 subtracted from 100 gives us 88 as result.
 */
public class SubtractTwoLInkList {
    public static void main(String[] args) {
        Node l1=new Node(1,new Node(2,new Node(3)));
        Node l2=new Node(2,new Node(2));
        Node f=sublinkedList(l1,l2);
        LinkListUtil.printList(f);
    }

    public static Node sublinkedList(Node l1, Node l2) {
        Node t1 = reverseList(l1);
        Node t2 = reverseList(l2);

        int t1Count=count(t1);
        int t2Count=count(t2);
        if(t1Count>=t2Count){
            return sub(t1, t2);
        }else{
            return sub(t2,t1);
        }
    }

    private static int count(Node t1) {
        int count=0;
        Node temp=t1;
        while(temp !=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    private static Node sub(Node t1, Node t2) {
        Node r = t1;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                if (getCarry(t1.next)) {
                    t1.data = t1.data + 10;
                }
            }
            t1.data = t1.data - t2.data;
            t1 = t1.next;
            t2 = t2.next;
        }

        r = reverseList(r);
        while(r!=null && r.data==0){
            r=r.next;
        }
        return r;
    }

    private static boolean getCarry(Node next) {
        if (next.data > 0) {
            next.data = next.data - 1;
            return true;
        } else if (next.data == 0) {
            if (getCarry(next.next)) {
                next.data = 9;
                return true;
            } else {
                return false;
            }
        }
        return false;
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
        current.next = prev;
        head.next = null;
        return current;

    }

}
