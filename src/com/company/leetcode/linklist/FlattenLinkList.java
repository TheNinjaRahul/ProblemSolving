package com.company.leetcode.linklist;

public class FlattenLinkList {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);


        Node n10 = new Node(10);
        Node n11 = new Node(11);


        n1.child = n2;
        n2.child = n3;
        n3.child = n4;

        /*n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        n3.child = n7;
        n7.next = n8;
        n8.next = n9;
*/
//        n8.child = n10;
//        n10.next = n11;


        Node n = flatten(n1);
        int i = 0;
        while (n.next != null && i++ != 20) {
            System.out.print(n.val + " ");
            n = n.next;
        }

        System.out.print(n.val + " ");
        System.out.println();
        while (n != null && i++ != 20) {
            System.out.print(n.val + " ");
            n = n.prev;
        }

    }


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }


    public static Node flatten(Node head) {
        if (head == null) return head;
        if (head.child != null) {
            Node next = head.next;
            Node childList = flatten(head.child);
            head.next = childList;
            head.child = null;
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = next;
            if (next != null) next.prev = temp;
            if (next != null) next.next = flatten(next.next);
        } else {
            head.next = flatten(head.next);
        }

        if (head.next == null) return head;

        if (head.next != null) {
            head.next.prev = head;
        }
        return head;

    }
}
