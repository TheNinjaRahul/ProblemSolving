package com.company.leetcode.BST;


public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val == key) {
            //check case 1
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.right == null || root.left == null) {
                return root.right == null ? root.left : root.right;
            } else {
                root.val = inOrderSuccessor(root.right);
                root.right = deleteNode(root.right, root.val);
                return root;
            }
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private static int inOrderSuccessor(TreeNode root) {
        if (root.left == null && root.right == null) return root.val;
        return root.left != null ? inOrderSuccessor(root.left) : root.val;
    }
}
