package com.company.GFG.LinkList;

public class SwapKthNodesFromEnds {
    public static void main(String[] args) {
        Node n=new Node(1,new Node(2,new Node(3,new Node(4, new Node(5)))));
        n=swapkthnode(n,5,5);
        LinkListUtil.printList(n);
    }

    static Node swapkthnode(Node head, int num, int K)
    {
        if(head==null || head.next==null) return head;
        if(K==0) return head;


        Node temp=head,p1=null,c1=null,p2=null,c2=null,p=null;
        int i=1;

        while(temp!=null){
            if(i==K){
                p1=p;
                c1=temp;
            }
            if(i==(num-K)+1){
                p2=p;
                c2=temp;
            }
            p=temp;
            temp=temp.next;
            i++;
        }
        if(c1==c2) return head;

        try{
            if(p1==null){
                head=c2;
                c2.next=c1.next;
                p2.next=c1;
                c1.next=null;
                return head;
            }

            if(K==num){
                head=c1;
                return head;
            }

        p1.next=c2;
        temp=c2.next;
        c2.next=c1.next;
        p2.next=c1;
        c1.next=temp;
        }catch (Exception e){
            System.out.println(num);
            System.out.println(K);
            e.printStackTrace();
        }
        return head;
    }
}
