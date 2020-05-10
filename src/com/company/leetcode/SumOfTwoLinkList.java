package com.company.leetcode;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class SumOfTwoLinkList {


    public static void main(String[] args) {
//        ListNode first=new ListNode(2,new ListNode(4,new ListNode(3)));
//        ListNode second=new ListNode(5,new ListNode(6,new ListNode(4)));


//            set.add(s.charAt())
//        int []i1=new int[]{9};
//        int []i2=new int[]{1,9,9,9,9,9,9,9,9,9};
//        int []i1=new int[]{3,9,9,9,9,9,9,9,9,9};
//        int []i2=new int[]{7};
        int[] i1 = new int[]{2,4,3};
        int[] i2 = new int[]{5,6,4};

//        int[] i1 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int[] i2 = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        ListNode first = null, temp = null, second = null;
        for (int i = 0; i < i1.length; i++) {
            if (first == null) {
                first = new ListNode(i1[i]);
                temp = first;
            } else {
                temp.next = new ListNode(i1[i]);
                temp = temp.next;
            }
        }

        for (int i = 0; i < i2.length; i++) {
            if (second == null) {
                second = new ListNode(i2[i]);
                temp = second;
            } else {
                temp.next = new ListNode(i2[i]);
                temp = temp.next;
            }
        }


        ListNode result = Solution.addTwoNumbers2(first, second);

        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }

    }
}


class Solution {

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode result = null, first = null;

        while (l1 != null || l2 != null) {
            int sum = 0;
            int i1 = l1 != null ? l1.val : 0;
            int i2 = l2 != null ? l2.val : 0;

            sum = carry + i1 + i2;
            if(sum>9){
                carry = sum / 10;
                sum = sum % 10;
            }else{
                carry=0;
            }

//            sum = sum / 10;

            if (first == null) {
                first = new ListNode(sum);
                result = first;
            } else {
                result.next = new ListNode(sum);
                result = result.next;
            }

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry!=0){
            result.next = new ListNode(carry);
        }

        return first;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode firstHead = l1;
        ListNode secondHead = l2;

        BigInteger i1 = BigInteger.valueOf(firstHead.val);
        BigInteger i2 = BigInteger.valueOf(secondHead.val);
        firstHead = firstHead.next;
        secondHead = secondHead.next;
        int i = 1;
        while (firstHead != null) {
            System.out.println("Node value:" + firstHead.val + " i1:" + i1 + "i: " + i);
            BigInteger mul = BigInteger.valueOf((long) Math.pow(10, i));
            BigInteger addnew = mul.multiply(BigInteger.valueOf(firstHead.val));
            i1 = i1.add(addnew);
            System.out.println(i + "--->" + i1);
            i++;
            firstHead = firstHead.next;
        }

        System.out.println("Final1: " + i1);
        i = 1;
        while (secondHead != null) {
            BigInteger mul = BigInteger.valueOf((long) Math.pow(10, i));
            BigInteger addnew = mul.multiply(BigInteger.valueOf(secondHead.val));
            i2 = i2.add(addnew);
            i++;
            secondHead = secondHead.next;
        }


        System.out.println(i1 + " " + i2);
        BigInteger sum = i1.add(i2);

        ListNode result = null, first = null;
        while (!sum.toString().equals("-1")) {
            double mod = sum.mod(BigInteger.valueOf(10)).intValue();
            sum = sum.divide(BigInteger.valueOf(10));
            if (sum.equals(BigInteger.ZERO)) {
                sum = new BigInteger("-1");
            }
            ListNode node = new ListNode((int) mod, null);

            if (result == null) {
                result = node;
                first = result;
            } else {
                result.next = node;
                result = result.next;
            }
        }
        return first;

    }


}
