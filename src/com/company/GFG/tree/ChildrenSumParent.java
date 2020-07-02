package com.company.GFG.tree;

public class ChildrenSumParent {
    public static void main(String[] args) {
        Node root = new Node(10, new Node(10, null, null), null);
        System.out.println(isSumProperty(root));
    }

    public static int isSumProperty(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return 1;
        }
        int left = root.left != null ? root.left.data : 0;
        int right = root.right != null ? root.right.data : 0;
        if (root.data == left + right && isSumProperty(root.left) != 0 && isSumProperty(root.right) != 0) {
            return 1;
        }
        return 0;
    }
}
