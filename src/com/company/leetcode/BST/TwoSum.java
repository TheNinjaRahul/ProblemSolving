package com.company.leetcode.BST;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TwoSum {
    public static void main(String[] args) {

    }


    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, new HashSet<Integer>(), k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(root.val)) return true;
        set.add(k - root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }


    public boolean findTarget2(TreeNode root, int k) {
        Set<Integer> list = new HashSet<>();
        inorder(root, list);
        for (Integer i : list) {
            if (list.contains(k - i) && k - i != i) {
                return true;
            }
        }
        return false;
    }

    private void inorder(TreeNode root, Set<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}
