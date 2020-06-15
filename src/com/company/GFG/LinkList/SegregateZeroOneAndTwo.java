package com.company.GFG.LinkList;

public class SegregateZeroOneAndTwo {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(2, new Node(1, new Node(2, new Node(0, new Node(2, new Node(2))))))));
        Node f = segregate(head);
        LinkListUtil.printList(f);
    }

    public static Node segregate(Node head){
        int count[]=new int[3];
        Node temp=head;

        while(temp!=null){
            count[temp.data]++;
            temp=temp.next;
        }

        temp=head;

        int i=0;
        while(temp!=null){
            while(count[i]!=0){
                temp.data=i;
                temp=temp.next;
                count[i]--;
            }
            i++;
        }

        return head;
    }

    public static Node segregate2(Node head) {

        Node z = null, zf = null, of = null, o = null, tf = null, t = null;
        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                if (z == null) {
                    z = temp;
                    zf = z;
                } else {
                    z.next = temp;
                    z = z.next;
                }
            } else if (temp.data == 1) {
                if (o == null) {
                    o = temp;
                    of = o;
                } else {
                    o.next = temp;
                    o = o.next;
                }
            } else if (temp.data == 2) {
                if (t == null) {
                    t = temp;
                    tf = t;
                } else {
                    t.next = temp;
                    t = t.next;
                }
            }
            temp = temp.next;
        }

        if (zf != null) {
            head = zf;
        }

        if (zf != null) {
            z.next = of;
        } else {
            head = of;
        }

        if (zf != null && of != null) {
            o.next = tf;
        } else {
            if (of == null && zf != null) {
                z.next = tf;
            } else if (of != null && zf == null) {
                o.next = tf;
            } else {
                head = tf;
            }
        }
        if (t != null) t.next = null;

        return head;

    }
}
