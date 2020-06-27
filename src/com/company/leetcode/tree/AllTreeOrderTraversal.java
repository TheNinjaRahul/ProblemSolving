package com.company.leetcode.tree;

import java.util.ArrayList;

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
        return null;
    }

    private static ArrayList<Integer> inOrderTraversalRec(TreeNode root) {
        return null;
    }

    private static ArrayList<Integer> postOrderTraversalRec(TreeNode root) {
        return null;
    }

    private static ArrayList<Integer> inOrderTraversal(TreeNode root) {
        return null;
    }

    private static ArrayList<Integer> preOrderTraversal(TreeNode root) {
        return null;
    }

    private static ArrayList<Integer> preOrderTraversalRec(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        list.add(root.val);
        list.addAll(preOrderTraversalRec(root.left));
        list.addAll(preOrderTraversalRec(root.right));
        return list;
    }
}
