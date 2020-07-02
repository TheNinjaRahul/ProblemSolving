package com.company.GFG.tree;

import sun.applet.AppletResourceLoader;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int pre[] = {3, 9, 20, 15, 7};
        int in[] = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(pre, in);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0], null, null);

        if (preorder.length != 1) {
            int rootIndex = findIndexIfRoot(inorder, root.val);
            int newpreL[] = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
            int newPreR[] = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);

            int newInL[] = Arrays.copyOfRange(inorder, 0, rootIndex);
            int newinR[] = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
            root.left = buildTree(newpreL, newInL);
            root.right = buildTree(newPreR, newinR);
        }
        return root;

    }

    public static Node buildTree(int ino[], int pre[], int st, int end) {
        if (pre.length == 0) return null;

        Node root = new Node(pre[0]);

        if (pre.length != 1) {
            int rootIndex = findIndexIfRoot(ino, root.data);
            int newpreL[] = Arrays.copyOfRange(pre, 1, 1 + rootIndex);
            int newPreR[] = Arrays.copyOfRange(pre, rootIndex + 1, pre.length);

            int newInL[] = Arrays.copyOfRange(ino, 0, rootIndex);
            int newinR[] = Arrays.copyOfRange(ino, rootIndex + 1, ino.length);
            root.left = buildTree(newpreL, newInL,0,0);
            root.right = buildTree(newPreR, newinR,0,0);
        }
        return root;

    }

    private static int findIndexIfRoot(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }
}
