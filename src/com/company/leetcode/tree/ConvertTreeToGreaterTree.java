package com.company.leetcode.tree;

import java.util.Stack;

public class ConvertTreeToGreaterTree {
    public static void main(String[] args) {
        TreeNode root = SerializationAndDeserialization.deserialize("[5,2,13]");
//        System.out.println(root);
        System.out.println(convertBST(root));
//        System.out.println(root);
    }

    static class Myclass {
        int val = 0;
    }

    public static TreeNode convertBST2(TreeNode root) {
        Myclass my = new Myclass();
        getAllValues(my, root);
        return root;
    }

    private static void getAllValues(Myclass my, TreeNode root) {
        if (root == null) return;
        getAllValues(my, root.right);
        root.val += my.val;
        my.val = root.val;
        getAllValues(my, root.left);
    }

    public static TreeNode convertBST(TreeNode root) {
        TreeNode temp2=root;
        int prev = 0;
        Stack<TreeNode> stack = new Stack<>();
        Myclass my = new Myclass();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else if (root == null) {
                TreeNode temp = stack.pop();
                temp.val += prev;
                prev = temp.val;
                root = temp.left;
            }
        }
        return temp2;
    }


}
