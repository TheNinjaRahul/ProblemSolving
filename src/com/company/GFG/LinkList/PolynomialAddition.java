package com.company.GFG.LinkList;

public class PolynomialAddition {
    public static void main(String[] args) {

    }

    public static Node addPolynomial(Node p1, Node p2) {

        if (p1 == null) return p2;
        if (p2 == null) return p1;

        Node temp = null,head=null;

        if (p1.pow == p2.pow) {
            if (temp == null) {
                p1.coeff += p2.coeff;
                temp = p1;
                p1 = p1.next;
                p2 = p2.next;
            }
        } else if (p1.pow > p2.pow) {
            temp = p1;
            p1 = p1.next;
        } else {
            temp = p2;
            p2 = p2.next;
        }

        head=temp;
        while (p1 != null && p2 != null) {
            if (p1.pow == p2.pow) {
                p1.coeff += p2.coeff;
                temp.next = p1;
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1.pow > p2.pow) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next= p2;
                p2 = p2.next;
            }
            temp=temp.next;
        }

        return head;

    }

    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }
}
