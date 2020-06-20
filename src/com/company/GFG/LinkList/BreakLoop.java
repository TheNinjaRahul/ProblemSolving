package com.company.GFG.LinkList;

public class BreakLoop {
    public static void main(String[] args) {
        Node n = new Node(1);
        Node n2 = new Node(2, new Node(3, new Node(4, new Node(5, n))));
        n.next = n2;
        removeLoop(n);
        LinkListUtil.printList(n);
    }

    public static void removeLoop(Node head) {
        Node temp = head, fast = head;
        while (fast != null && fast.next != null) {
            temp = temp.next;
            fast = fast.next.next;
            if (temp == fast) {
                Node t = temp, t2 = head;
                // Node prev=null;
                while (t.next != t2.next) {
                    t = t.next;
                    // prev=t2;
                    t2 = t2.next;
                }
                if (t == head) {
                    t2 = t2.next;
                    while (t2.next != t) {
                        t2 = t2.next;
                    }

                    t2.next = null;
                } else {
                    t.next = null;
                }
            }
        }
    }
}
