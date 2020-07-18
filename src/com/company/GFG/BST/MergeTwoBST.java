package com.company.GFG.BST;

import javax.swing.plaf.nimbus.State;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class MergeTwoBST {
    public static void main(String[] args) {
        Node root1 = DriverCode.buildTree("5 3 6 2 4");
        Node root2 = DriverCode.buildTree("2 1 3 N N N 7 6");
        System.out.println(merge(root1, root2));

    }


    public static List<Integer> merge(Node root1, Node root2) {
        List<Integer> list = new LinkedList<>();
        helper(root1, root2);
        inOrder(root1, list);
        return list;
    }

    private static Node helper(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        if (root1.data > root2.data) {
            Node right = root2.right;
            root2.right = null;

            root1.left = helper(root1.left, root2);
            helper(root1, right);
        } else {
            Node left = root2.left;
            root2.left = null;

            root1.right = helper(root1.right, root2);
            helper(root1, left);
        }
        return root1;

    }

    public static List<Integer> merge2(Node root1, Node root2) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        boolean oneStackEmpty = false;
        List<Integer> list = new LinkedList<>();
        while (!s1.isEmpty() || !s2.isEmpty() || root1 != null || root2 != null) {
//            System.out.println(list);
            if (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            } else if (root2 != null) {
                s2.push(root2);
                root2 = root2.left;
            } else if (root1 == null && root2 == null) {
                if (s1.isEmpty() || s2.isEmpty()) {
                    oneStackEmpty = true;
                }
                if (oneStackEmpty) {
                    while (!s1.isEmpty()) {
                        Node temp = s1.pop();
                        temp.left = null;
                        inOrder(temp, list);

                    }
                    while (!s2.isEmpty()) {
                        Node temp = s2.pop();
                        temp.left = null;
                        inOrder(temp, list);
                    }
                    break;
                }
                if (s1.peek().data < s2.peek().data) {
                    Node temp = s1.pop();
                    list.add(temp.data);
                    root1 = temp.right;
                } else {
                    Node temp = s2.pop();
                    list.add(temp.data);
                    root2 = temp.right;
                }
            }
        }
        return list;
    }

    private static void inOrder(Node temp, List<Integer> list) {
        if (temp == null) return;
        inOrder(temp.left, list);
        list.add(temp.data);
        inOrder(temp.right, list);
    }
}
