package com.company.leetcode.BST;

import com.company.leetcode.tree.SerializationAndDeserialization;

/*
https://leetcode.com/problems/recover-binary-search-tree/
 */
public class RecoverTree {
    public static void main(String[] args) {

    }

    TreeNode firstNode = null, lastNode = null, prev = null;

    public void recoverTree(TreeNode root) {
        findPair(root);
        int temp = firstNode.val;
        firstNode.val = lastNode.val;
        lastNode.val = temp;
    }

    private void findPair(TreeNode root) {
        if (root == null) return;
        findPair(root.left);
        if (prev != null) {
            if (prev.val > root.val) {
                if (firstNode == null) {
                    firstNode = prev;
                }
                lastNode = prev;
            }
        }
        prev = root;
        findPair(root.right);
    }

}
