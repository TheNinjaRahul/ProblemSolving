package com.company.leetcode.tree;

public class SumOfRootToLeafBinary {
    public static void main(String[] args) {

    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        return rec(root, 0);
    }

    public int rec(TreeNode root, int v) {
        if (root == null) return v;
        int val = root.val + 2 * v;
        int result = rec(root.left, val);
        result += rec(root.right, val);
        return result;
    }

    public int sumRootToLeaf2(TreeNode root) {
        if (root == null) return 0;
        StringBuilder sb = new StringBuilder();
        return rec2(root, sb);
    }

    public int rec2(TreeNode root, StringBuilder sb) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            int result = Integer.parseInt(sb.toString(), 2);
            sb.deleteCharAt(sb.length() - 1);
            return result;
        }
        sb.append(root.val);
        int result = rec2(root.left, sb);
        result += rec2(root.right, sb);

        sb.deleteCharAt(sb.length() - 1);
        return result;
    }
}
