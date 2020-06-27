package com.company.GFG.LinkList;

/**
 * Given a singly linked list, remove all the nodes which have a greater value on its next adjacent element.
 * <p>
 * Input:
 * First line of input contains numbe of testcases T. For each testcase, first line of input contains length of the linked list and next line contains the elements of the linked list.
 * <p>
 * Output:
 * For each testcase, print the modified linked list.
 * <p>
 * User Task:
 * The task is to complete the function compute() which should modify the list as required. The printing is done by the driver code,
 * <p>
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(1)
 * <p>
 * Constraints:
 * 1 <= T <= 1000
 * 1 <= size of linked list <= 1000
 * 1 <= element of linked list <= 1000
 * Note: Try to solve the problem without using any extra space.
 * <p>
 * Example:
 * Input:
 * 3
 * 8
 * 12 15 10 11 5 6 2 3
 * 6
 * 10 20 30 40 50 60
 * 6
 * 60 50 40 30 20 10
 * <p>
 * Output:
 * 15 11 6 3
 * 60
 * 60 50 40 30 20 10
 * <p>
 * Explanation:
 * Testcase 1: Since, 12, 10, 5 and 2 are the elements which have greater elements on their next node. So, after deleting them, the linked list would like be 15, 11, 6, 3.
 */

public class DeleteNodesHavingGreaterValueOnRight {
    public static void main(String[] args) {
        Node n = new Node(12, new Node(15, new Node(10, new Node(11, new Node(5, new Node(6,
                new Node(2, new Node(3))))))));

        Node n1=new Node(10,new Node(20,new Node(30,new Node(40,new Node(50,new Node(60))))));
        Node n3=new Node(60,new Node(50,new Node(40,new Node(30,new Node(20,new Node(10))))));
        Node r=compute(n3);
        LinkListUtil.printList(r);
    }

    static Node compute(Node head)
    {
        if(head==null) return head;
        Node a=compute(head.next);

        if(a!=null && a.data>head.data){
            head=a;
            return head;
        }else{
            head.next=a;
        }
        return head;
    }

    static Node compute2(Node head) {
        if (head == null || head.next == null) return head;
//        if (head.data < head.next.data) {
//            head = head.next;
//        }

        while(head.next!=null && head.data < head.next.data){
            head = head.next;
        }
        if(head.next==null) return head;
        Node p=head;
        Node c=head.next;
        Node n=c.next;
        while(c!=null && n!=null){
            if(c.data<n.data){
                p.next=n;
                p=n;
                c=  (p.next!=null) ? p.next:null;
                n=(c!=null && c.next!=null) ? c.next:null;
                continue;
            }
            p=c;
            c=n;
            n=n.next;
        }
        return head;
    }

}
