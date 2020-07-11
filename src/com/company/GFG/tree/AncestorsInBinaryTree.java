package com.company.GFG.tree;

public class AncestorsInBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean printAncestors(Node root, int k) {
        StringBuilder sb = new StringBuilder();
        boolean left = getLeafCount(root.left, sb, k);
        boolean right = getLeafCount(root.right, sb, k);
        if (left || right ) {
            sb.append(root.data + " ");
        }

        if (sb.length() == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
        return true;
    }

    private static boolean getLeafCount(Node root, StringBuilder sb, int k) {
        if (root == null) return false;
        if (root.data==k) return true;

        boolean left = getLeafCount(root.left, sb, k);
        boolean right = getLeafCount(root.right, sb, k);
        if (left || right ) {
            sb.append(root.data + " ");
        }
        return left||right;

    }
}
