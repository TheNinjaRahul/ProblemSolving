package com.company.GFG.BST;

import java.sql.DriverAction;

public class LCA {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("5 4 6 3 N N 7 N N N 8");
        System.out.println(LCA(root, 7, 8));

        Node root2 = DriverCode.buildTree("2 1 3");
        System.out.println(LCA(root2, 1, 3));
    }

    public static Node LCA(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.data > n1 && root.data < n2) return root;

        if (root.data == n1 || root.data == n2) return root;
        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (left != null && right != null) return root;
        return left != null ? left : right;

    }
}
