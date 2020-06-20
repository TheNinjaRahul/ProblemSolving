package com.company.GFG.LinkList;


public class CloneLinkListWithRandomPointer {
    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;


        n1.arb = null;
        n2.arb = n1;
        n3.arb = n5;
        n4.arb = n3;
        n5.arb = n1;

        int i = 0;
        Node n = n1;
        while (n != null) {
            if (i++ == 20) break;
            System.out.print(n.data + " --Random:" + (n.arb != null ? n.arb.data : null) + " " + n.arb + ",");
            n = n.next;

        }
        Node m = copyList(n1);
        System.out.println();
        i = 0;
        while (m != null) {
            if (i++ == 20) break;
            System.out.print(m.data + " --Random:" + (m.arb != null ? m.arb.data : null) + " " + m.arb + ",");
            m = m.next;
        }
    }

    static Node copyList(Node head) {
        Node temp = head;
        Node head2 = null, p = null;
        while (temp != null) {
            Node next = temp.next;
            Node n = new Node(temp.data);
            n.next = next;
            temp.next = n;
            if (head2 == null) {
                head2 = n;
                temp = next;
                continue;
            }
            temp = next;
        }
        temp = head;
        while (temp != null) {
            if (temp.next.next == null) {
                if (temp.arb == null) {
                    temp.next.arb = null;
                } else {
                    temp.next.arb = temp.arb.next;
                }
                temp = null;
                break;
            }
            if (temp.arb == null) {
                temp.next.arb = null;
            } else {
                temp.next.arb = temp.arb.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        while (temp.next != null) {
            if(temp.next.next==null){
                temp.next=null;
                break;
            }
            Node t1=temp.next.next.next;
            Node t2=temp.next.next;
            temp.next.next=t1;
            temp.next=t2;
            temp = temp.next;
        }
        return head2;
    }

    static class Node {
        int data;
        Node next, arb;

        Node(int d, Node n) {
            data = d;
            next = n;
            arb = null;
        }

        Node(int d) {
            data = d;
        }
    }
}
