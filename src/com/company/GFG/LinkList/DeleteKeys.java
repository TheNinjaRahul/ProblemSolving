package com.company.GFG.LinkList;

public class DeleteKeys {
    public static void main(String[] args) {
        Node head = new Node(2, new Node(2, new Node(1, new Node(4,new Node(4)))));
        Node f=deleteAllOccurances(head,4);
        LinkListUtil.printList(f);

    }

    public static Node deleteAllOccurances(Node head, int x)
    {
        if(head==null || head.next==null) return head;
        while(head.data==x){
            head=head.next;
        }
        Node temp=head;
        while(head.next!=null){
            if(head.next.data==x){
                head.next=head.next.next;
            }else{
                head=head.next;
            }
        }
        return temp;
    }
}
