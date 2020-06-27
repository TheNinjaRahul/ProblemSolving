package com.company.leetcode.tree;

import javax.swing.plaf.IconUIResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(postorderTraversal2(root));
    }


    public static List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }


    public static List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        TreeNode current = root;
        while (!s1.isEmpty() || current != null) {
            if (current != null) {
                s1.push(current);
                current = current.left;
            } else {
                TreeNode temp = s1.peek().right;
                if (temp == null) {
                    temp = s1.pop();
                    list.add(temp.val);

                    while (!s1.isEmpty() && s1.peek().right == temp) {
                        temp = s1.pop();
                        list.add(temp.val);
                    }

                } else {
                    current = temp;
                }
            }
        }
        return list;
    }
}
