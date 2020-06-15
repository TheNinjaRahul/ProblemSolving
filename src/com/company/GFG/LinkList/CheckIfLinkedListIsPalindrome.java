package com.company.GFG.LinkList;

import java.util.Stack;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 */
public class CheckIfLinkedListIsPalindrome {
    public static void main(String[] args) {

    }

    boolean isPalindrome(Node head)
    {
        Node slow=head,fast=head;
        Stack<Integer> stack=new Stack<>();

        while(fast!=null){
            stack.push(slow.data);
            slow=slow.next;
            if(fast.next==null){
                stack.pop();
                break;
            }else{
                fast= fast.next.next;
            }
        }

        while(slow!=null){
            int poped=stack.pop();
            if(poped!=slow.data){
                return false;
            }else{
                slow=slow.next;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
