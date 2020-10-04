package com.company.leetcode.BST;

import com.company.GFG.tree.ConvertLinkListToArray;

import java.util.LinkedList;
import java.util.Queue;

public class IsEvenOddTree {
    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(1, new TreeNode(10, new TreeNode(3, new TreeNode(12), new TreeNode(8)), null),
                new TreeNode(4, new TreeNode(7, new TreeNode(6), null), new TreeNode(9, null, new TreeNode(2))));

        System.out.println("TRUE-" + isEvenOddTree(t2));
        TreeNode treeNode = new TreeNode(5, new TreeNode(4, new TreeNode(3), new TreeNode(3)), new TreeNode(2, new TreeNode(7), null));
        System.out.println("FALSE-" + isEvenOddTree(treeNode));
    }

    public static boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean toCheckOdd = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode first = null;
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                if (level % 2 == 0) {
                    if (temp.val % 2 != 1) return false;
                } else {
                    if (temp.val % 2 != 0) return false;
                }
                if (first == null) {
                    first = temp;
                } else {
                    if (level % 2 == 0) {
                        if (first.val >= temp.val) return false;
                    } else {
                        if (first.val <= temp.val) return false;
                    }
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                first = temp;
            }
            level++;
        }
        return true;
    }
}
