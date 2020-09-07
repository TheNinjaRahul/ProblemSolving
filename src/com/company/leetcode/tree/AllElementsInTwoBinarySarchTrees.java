package com.company.leetcode.tree;

import java.util.LinkedList;
import java.util.List;

public class AllElementsInTwoBinarySarchTrees {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder();


    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        return  null;
    }

    public List<Integer> getAllElements2(TreeNode root1, TreeNode root2) {
        List<Integer> list = new LinkedList<>();
        if (root1 == null && root2 == null) {
            return list;
        } else if (root1 == null) {
            inOrderOf(root2, list);
        } else if (root2 == null) {
            inOrderOf(root1, list);
        } else {
            if (root1.val == root2.val) {
                list.addAll(getAllElements(root1.left, root2.left));
                list.add(root1.val);
                list.add(root1.val);

                list.addAll(getAllElements(root1.right, root2.right));
            } else if (root1.val < root2.val) {
                TreeNode right1 = root1.right;
                TreeNode left2 = root2.left;
                root1.right = null;
                root2.left = null;
                list.addAll(getAllElements(root1, left2));
                list.addAll(getAllElements(right1, root2));
                // inOrderOf(root1,list);
                // list.addAll(getAllElements(right,root2));
            } else if (root1.val > root2.val) {
                TreeNode right2 = root2.right;
                TreeNode left1 = root1.left;
                root2.right = null;
                root1.left = null;
                list.addAll(getAllElements(left1, root2));
                list.addAll(getAllElements(root1, right2));
                // inOrderOf(root2,list);
                // list.addAll(getAllElements(right,root1));
            }
        }
        return list;
    }

    public void inOrderOf(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inOrderOf(root.left, list);
        list.add(root.val);
        inOrderOf(root.right, list);
    }
}
