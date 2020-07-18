package com.company.leetcode.tree;

import com.company.GFG.tree.TreeUtil;

import java.util.Arrays;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        int[] data = {4,2};
        TreeNode root = bstFromPreorder(data);
//        TreeUtil.inOrderTraversal();
        System.out.println(root.val);
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i = 1;
        if (preorder.length == 1) return root;
        while (i<preorder.length && root.val > preorder[i]) {
            i++;
        }

        System.out.println();
        root.left = bstFromPreorder(Arrays.copyOfRange(preorder, 1, i ));
        root.right = bstFromPreorder(Arrays.copyOfRange(preorder, i , preorder.length));
        return root;
    }
}
