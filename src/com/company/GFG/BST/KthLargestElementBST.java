package com.company.GFG.BST;

public class KthLargestElementBST {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("4 2 9 1 3 N 10");
        System.out.println(kthLargest(root, 3));

        Node root2 = DriverCode.buildTree("9 N 10");
        System.out.println(kthLargest(root2, 1));
    }

    static class myclass {
        int count;
        int element;
        boolean found = false;
    }

    public static int KthSmallestElement(Node root, int K) {
        myclass m = new myclass();
        KthSmallestElement(m, root, K);
        return m.element;

    }

    private static void KthSmallestElement(myclass m, Node root, int k) {
        if (root == null) return;

        if (m.found) return;
        if (root.left != null) {
            KthSmallestElement(m, root.left, k);
        }

        m.count++;

        if (m.count == k) {
            m.element = root.data;
            m.found = true;
            return;
        }

        if (root.right != null) {
            KthSmallestElement(m, root.right, k);
        }

    }

    public static int kthLargest(Node root, int K) {
        myclass m = new myclass();
        findKthElement(m, root, K);
        return m.element;

    }

    private static void findKthElement(myclass m, Node root, int k) {
        if (root == null) return;

        if (m.found) return;
        if (root.right != null) {
            findKthElement(m, root.right, k);
        }
        m.count++;

        if (m.count == k) {
            m.element = root.data;
            m.found = true;
            return;
        }

        if (root.left != null) {
            findKthElement(m, root.left, k);
        }
    }
}
