package com.company.GFG.BST;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MedianOfBST {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("6 3 8 1 4 7 9");
        findMedian(root);
        Node root2 = DriverCode.buildTree("6 3 8 1 4 7");
        findMedian(root2);

        Node root3 = DriverCode.buildTree("4 2");
        findMedian(root3);
    }

    public static void findMedian(Node root) {

        List<Node> list = new LinkedList<>();
        if (root == null) return;

        Stack<Node> stack = new Stack<>();
//        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (root == null) {
                Node temp = stack.pop();
                list.add(temp);
                root = temp.right;
            }
        }
        if (list.size() % 2 == 0) {
            int a = (list.size() - 1) / 2;
            int b = (list.size()) / 2;
            double result=(double) (list.get(a).data + list.get(b).data) / 2;
            int r= (int) result;
            if(r<result){
                System.out.print(result);
            }else {
                System.out.print(r);
            }

        } else {
            int a = (list.size() - 1) / 2;
            System.out.println((list.get(a).data));
        }
    }
}
