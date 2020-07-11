package com.company.leetcode.tree;

public class IsSubTree {

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5));
        TreeNode t = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(s,t));
        TreeNode s2 = new TreeNode(1, new TreeNode(1), null);
        TreeNode t2 = new TreeNode(1);
        System.out.println(isSubtree(s2, t2));

        TreeNode s3 = new TreeNode(3, new TreeNode(4, new TreeNode(1), null), new TreeNode(5, new TreeNode(2), null));
        TreeNode t3 = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(s3, t3));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (isMatched(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static boolean isMatched(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val && isMatched(s.left, t.left) && isMatched(s.right, t.right)) {
            return true;
        }
        return false;
    }
}
