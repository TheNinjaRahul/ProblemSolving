package com.company.GFG.tree;

public class PrintNodesHavingKLeaves {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("0 1 2");
        btWithKleaves(root, 1);
        Node root2 = DriverCode.buildTree("0 1 2 N N 4 N 5 9");
        btWithKleaves(root2, 2);

        Node root3 = DriverCode.buildTree("91 10 N 77 69 N 2 66 N 49 56 N 6 11 N 15 93 N 7 15 N 76 55 N 5 83 N 91 9 N 69");
        btWithKleaves(root3, 6);

    }

    public static void btWithKleaves(Node root, int k) {
        StringBuilder sb = new StringBuilder();
        int left = getLeafCount(root.left, sb, k);
        int right = getLeafCount(root.right, sb, k);
        if (left + right == k) {
            sb.append(root.data + " ");
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }


    }

    private static Integer getLeafCount(Node root, StringBuilder sb, int k) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int left = getLeafCount(root.left, sb, k);
        int right = getLeafCount(root.right, sb, k);
        if (left + right == k) {
            sb.append(root.data + " ");
        }
        return left + right;

    }
}
