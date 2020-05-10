package com.company.leetcode;

public class RemoveLastNthNodeFromLinkList {
    public static void main(String[] args) {
//            ListNode first=new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
////        ListNode first=new ListNode(1,new ListNode(2,null));
//            ListNode n=removeNthFromEnd(first,2);
//
//            while(n!=null){
//                System.out.print(" "+n.val);
//                n=n.next;
//            }

        ListNode second=new ListNode(1,new ListNode(2,null));
        ListNode m=removeNthFromEnd(second,2);

        while(m!=null){
            System.out.print(" "+m.val);
            m=m.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode last=null;
        ListNode delete=head;
        ListNode prev=null;

        int i=0;
        while(i<n){
            if(last==null){
                last=head;
            }else{
                last=last.next;
            }
            i++;
        }
//        System.out.println(last.val);

        while(last.next!=null){
            if(delete==null){
                delete=head;
            }
            prev=delete;
            last=last.next;
            delete=delete.next;
        }
        if(prev==null && delete==null){
            return null;
        }
        if(prev==null && delete!=null){
            return delete.next;
        }
        prev.next=delete.next;
        return head;

    }
}



