package com.company.GFG.LinkList;

public class AddTwoNumber {
    public static void main(String[] args) {
        Node n1 = new Node(2, new Node(4, new Node(3)));
        Node n2 = new Node(5, new Node(6, new Node(4)));
        Node h = addTwoLists(n1, n2);
        LinkListUtil.printList(h);
    }

    public Node addTwoNumbers(Node l1, Node l2){

        int carry = 0;
        Node result = null, first = null;

        while (l1 != null || l2 != null) {
            int sum = 0;
            int i1 = l1 != null ? l1.data : 0;
            int i2 = l2 != null ? l2.data : 0;

            sum = carry + i1 + i2;
            if(sum>9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry=0;
            }

//            sum = sum / 10;

            if (first == null) {
                first = new Node(sum);
                result = first;
            } else {
                result.next = new Node(sum);
                result = result.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry!=0){
            result.next = new Node(carry);
        }
        return first;
    }

    public static Node addTwoLists(Node first, Node second) {
        Node temp = first, temp2 = second;
        Node res = null, t = null;
        int carry = 0;
        while (temp != null && temp2 != null) {
            int result = carry + temp.data + temp2.data;
            Node n = new Node(result % 10);
            if (result >= 10) {
                carry = result / 10;
            } else {
                carry = 0;
            }

            if (res == null) {
                res = n;
                t = n;
            } else {
                t.next = n;
                t = n;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        while (temp != null) {
            int result = carry + temp.data;
            Node n = new Node(result % 10);
            if (result > 10) {
                carry = result / 10;
            } else {
                carry = 0;
            }
            t.next = n;
            t = n;
            temp = temp.next;
        }

        while (temp2 != null) {
            int result = carry + temp2.data;
            Node n = new Node(result % 10);
            if (result > 10) {
                carry = result / 10;
            } else {
                carry = 0;
            }
            t.next = n;
            t = n;
            temp2 = temp2.next;
        }

        if(carry>0){
            Node n=new Node(carry);
            t.next=n;
        }

        return res;
    }
}
