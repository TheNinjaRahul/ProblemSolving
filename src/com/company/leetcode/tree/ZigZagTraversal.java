package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(zigZagTraversal(root));
    }

    public  static ArrayList<Integer> zigZagTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean rightToleft = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if (rightToleft) {
                    if (temp.right != null) queue.add(temp.right);
                    if (temp.left != null) queue.add(temp.left);
                } else {
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
                }
            }
            rightToleft = !rightToleft;
        }
        return list;

    }
}
