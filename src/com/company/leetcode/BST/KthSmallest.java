package com.company.leetcode.BST;

public class KthSmallest {
    public static void main(String[] args) {

    }

    static class myclass {
        int count;
        int element;
        boolean found = false;
    }

    public int kthSmallest(TreeNode root, int k) {
        myclass m = new myclass();
        findKthSmallElement(m, root, k);
        return m.element;

    }

    private static void findKthSmallElement(myclass m, TreeNode root, int k) {
        if (root == null) return;

        if (m.found) return;

        if (root.left != null) {
            findKthSmallElement(m, root.left, k);
        }

        m.count++;

        if (m.count == k) {
            m.element = root.val;
            m.found = true;
            return;
        }

        if (root.right != null) {
            findKthSmallElement(m, root.right, k);
        }

    }

}
