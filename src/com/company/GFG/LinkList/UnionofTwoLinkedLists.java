package com.company.GFG.LinkList;

/***
 * Union of Two Linked Lists
 * Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the distinct elements only.
 *
 * Input:
 * The function takes 2 arguments, reference pointer to the head of the first linked list (head1) and reference pointer to the head of the second linked list (head2).
 * There are multiple test cases and for each test case this function will be called separately.
 *
 * Output:
 * The function should return reference pointer to the head of the new list that is formed by the union of the two the lists.
 * Note: The new list formed should be in non-decreasing order.
 *
 * User Task:
 * The task is to complete the function makeUnion() which makes the union of the given two lists.
 *
 * Expected Time Complexity: O(N * Log(N))
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=5000
 *
 * Example:
 * Input:
 * 1
 * 6
 * 9 6 4 2 3 8
 * 5
 * 1 2 8 6 2
 *
 * Output:
 * 1 2 3 4 6 8 9
 *
 * Explanation:
 * Testcase 1: Union of the given two lists have elements 1, 2, 3, 4, 6, 8 and 9 in the list.Union of Two Linked Lists
 * Given two linked lists, your task is to complete the function makeUnion(), that returns the union of two linked lists. This union should include all the distinct elements only.
 *
 * Input:
 * The function takes 2 arguments, reference pointer to the head of the first linked list (head1) and reference pointer to the head of the second linked list (head2).
 * There are multiple test cases and for each test case this function will be called separately.
 *
 * Output:
 * The function should return reference pointer to the head of the new list that is formed by the union of the two the lists.
 * Note: The new list formed should be in non-decreasing order.
 *
 * User Task:
 * The task is to complete the function makeUnion() which makes the union of the given two lists.
 *
 * Expected Time Complexity: O(N * Log(N))
 * Expected Auxiliary Space: O(N)
 *
 * Constraints:
 * 1<=T<=100
 * 1<=N<=5000
 *
 * Example:
 * Input:
 * 1
 * 6
 * 9 6 4 2 3 8
 * 5
 * 1 2 8 6 2
 *
 * Output:
 * 1 2 3 4 6 8 9
 *
 * Explanation:
 * Testcase 1: Union of the given two lists have elements 1, 2, 3, 4, 6, 8 and 9 in the list.
 */
public class UnionofTwoLinkedLists {
    public static void main(String[] args) {
//        Node l1= new Node(9,new Node(6,new Node(4,new Node(2,new Node(3,new Node(8))))));
//        Node l2=new Node(1,new Node(2,new Node(8,new Node(6,new Node(2)))));
//        Node l=findUnion(l1,l2);
        Node l3=new Node(6,new Node(6,new Node(8,new Node(4,new Node(4,new Node(4,new Node(6,new Node(2))))))));
        Node l4=new Node(2,new Node(5,new Node(3)));
        Node l=findUnion(l3,l4);
        LinkListUtil.printList(l);
    }

    public static Node findUnion(Node head1, Node head2) {

        if(head1==null) return head2;
        if(head2==null) return head1;

        head1=mergeSort(head1);
        head2=mergeSort(head2);
        head2=deleteDuplicates(head2);
        head1=deleteDuplicates(head1);
        // LinkListUtil.printList(head1);
        // System.out.println();
        // LinkListUtil.printList(head2);
        // System.out.println();
        Node temp = null,result=null;
        if (head1.data == head2.data) {
            temp = head1;
            head1 = head1.next;
            head2 = head2.next;
        } else if (head1.data > head2.data) {
            temp = head2;
            head2 = head2.next;
        } else {
            temp = head1;
            head1 = head1.next;
        }
        result=temp;
        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                temp.next = head1;
                temp=temp.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data > head2.data) {
                if(temp.data==head2.data){
                    head2=head2.next;
                    continue;
                }
                temp.next = head2;
                temp=temp.next;
                head2 = head2.next;
            } else {
                if(temp.data==head1.data){
                    head1=head1.next;
                    continue;
                }
                temp.next = head1;
                temp=temp.next;
                head1 = head1.next;
            }
        }

        temp.next = head1==null ? head2:head1;
//        if(head1!=null) temp.next=deleteDuplicates(head1);
//        if(head2!=null) result.next=deleteDuplicates(head2);
        return result;
    }

    static public Node deleteDuplicates(Node root) {
        if(root==null) return null;

        Node c=root,t=root;

        while(t!=null){
            if(t.data!=c.data){
                c.next=t;
                c=c.next;
            }
            t=t.next;
        }
        c.next=null;
        return root;
    }
    static Node mergeSort(Node head)
    {
        if(head==null || head.next==null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }

        Node l2=slow.next;
        slow.next=null;
        Node l1=head;
        l1=mergeSort(l1);
        l2=mergeSort(l2);
        return sortedMerge(l1,l2);
    }



    static Node sortedMerge(Node headA, Node headB){
        Node temp=null;
        if(headA==null){
            return headB;
        }
        if(headB==null){
            return headA;
        }
        if(headA.data<headB.data){
            temp=headA;
            headA=headA.next;
        }else{
            temp=headB;
            headB=headB.next;
        }
        Node head=temp;
        while(headA!=null && headB!=null){
            if(headA.data<=headB.data){
                temp.next=headA;
                headA=headA.next;
            }else{
                temp.next=headB;
                headB=headB.next;
            }
            temp=temp.next;
        }
        if(headA!=null){
            temp.next=headA;
        }else {
            temp.next=headB;
        }
        return head;
    }

}
