package com.company.leetcode.BST;

import java.util.LinkedList;
import java.util.List;

public class GetAllElementInTwoBinaryTree {
    public static void main(String[] args) {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> t1 = new LinkedList<>();
        List<Integer> t2 = new LinkedList<>();

        inorder(t1, root1);
        inorder(t2, root2);

        List<Integer> list = new LinkedList<>();

        int i = 0, j = 0, m = t1.size(), n = t2.size();

        while (t1.size() != 0 && t2.size() != 0) {
            if (t1.get(0) <= t2.get(0)) {
                list.add(t1.get(0));
                t1.remove(0);
            } else {
                list.add(t2.get(0));
                t2.remove(0);
            }
        }
        if (t1 != null) list.addAll(t1);
        if (t2 != null) list.addAll(t2);

        return list;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }
}
