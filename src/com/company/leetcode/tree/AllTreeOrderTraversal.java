package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.Stack;

public class AllTreeOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("========= PreOrder =============");
        System.out.println(preOrderTraversalRec(root));
        System.out.println(preOrderTraversal(root));
        System.out.println("========= InOrder =============");
        System.out.println(inOrderTraversalRec(root));
        System.out.println(inOrderTraversal(root));
        System.out.println("========= PostOrder =============");
        System.out.println(postOrderTraversalRec(root));
        System.out.println(postOrderTraversal(root));
    }

    private static ArrayList<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current == null) {
                if (stack.peek().right != null) {
                    current = stack.peek().right;
                } else {
                    TreeNode temp = stack.pop();
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        list.add(temp.val);
                        temp = stack.pop();
                    }
                    list.add(temp.val);
                }
            } else {
                stack.push(current);
                current = current.left;
            }
        }
        return list;
    }

    private static ArrayList<Integer> inOrderTraversalRec(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(inOrderTraversalRec(root.left));
        list.add(root.val);
        list.addAll(inOrderTraversalRec(root.right));
        return list;
    }

    private static ArrayList<Integer> postOrderTraversalRec(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.addAll(postOrderTraversalRec(root.left));
        list.addAll(postOrderTraversalRec(root.right));
        list.add(root.val);
        return list;
    }

    private static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        TreeNode current = root;
        while (!stack.isEmpty() || current != null) {
            if (current == null) {
                current = stack.pop();
                list.add(current.val);
                current=current.right;
            } else {
                stack.push(current);
                current = current.left;
            }
        }
        return list;
    }

    private static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if (temp.right != null) stack.push(temp.right);
            if (temp.left != null) stack.push(temp.left);
        }
        return list;
    }

    private static ArrayList<Integer> preOrderTraversalRec(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        list.addAll(preOrderTraversalRec(root.left));
        list.addAll(preOrderTraversalRec(root.right));
        return list;
    }
}
