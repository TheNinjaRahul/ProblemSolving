package com.company.leetcode.BST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInorderPostOrder {

    public static void main(String[] args) {

        int inorder[] = {4, 2, 5, 1, 6, 3, 7};
        int postOrder[] = {4, 5, 2, 6, 7, 3, 1};
        TreeNode root = buildTree(inorder, postOrder);
        System.out.println(root);

        int i4[] = {1, 2, 3, 4};
        int p4[] = {1, 4, 3, 2};
        TreeNode r4 = buildTree(i4, p4);
        System.out.println(r4);

        int inorder3[] = {3, 2, 4, 1};
        int postOrder3[] = {3, 4, 2, 1};
        TreeNode root3 = buildTree(inorder3, postOrder3);
        System.out.println(root3);


        int inorder2[] = {1, 3, 2, 4};
        int postOrder2[] = {3, 4, 2, 1};
        TreeNode root2 = buildTree(inorder2, postOrder2);
        System.out.println(root2);


    }


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;
        if (postorder.length == 1 && inorder.length == 1) return new TreeNode(postorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int inorderPos = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                inorderPos = i;
                break;
            }
        }
        if (inorderPos == inorder.length - 1) {
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, inorderPos), Arrays.copyOfRange(postorder, 0, postorder.length - 1));
        } else if (inorderPos == 0) {
            root.right = buildTree(Arrays.copyOfRange(inorder, 1, inorder.length), Arrays.copyOfRange(postorder, 0, postorder.length - 1));
        } else {
            int len = inorder.length - inorderPos - 1;
            root.left = buildTree(Arrays.copyOfRange(inorder, 0, inorderPos), Arrays.copyOfRange(postorder, 0, postorder.length - 1 - len));
            root.right = buildTree(Arrays.copyOfRange(inorder, inorderPos + 1, inorder.length), Arrays.copyOfRange(postorder, postorder.length - 1 - len, postorder.length - 1));

        }
        return root;
    }
}
