package com.company.GFG.LinkList;

public class DoublyLinkListDelete {
    public static void main(String[] args) {

        Node n = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);


        n.next = n1;
        n1.prev = n;

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n = deleteNode(n, 4);

        int i = 0;
        while (n != null) {
            if (i++ == 10) break;
            System.out.print(n.data + "->");
            n = n.next;
        }

    }

    static Node deleteNode(Node head, int x) {
        if (head == null) return head;
        if (1 == x) {
            return head.next;
        }
        if (head.next == null) return head;

        int i = 0;
        Node temp = head;
        while (temp != null) {
            i++;
            if (i == x) {
                if (temp.next == null) {
                    temp.prev.next = null;
                    break;
                }
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                break;
            }
            temp = temp.next;
        }
        return head;
    }


    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
}
