package com.company.GFG.tree;

public class RemoveHalfNodes {
    public static void main(String[] args) {
        Node root = new Node(7, new Node(7, new Node(2), null), new Node(8));
        root = RemoveHalfNodes(root);
        TreeUtil.inOrderTraversal(root);
    }

    public static Node RemoveHalfNodes(Node root) {

        if (root == null) return root;
        if (root.left != null && root.right != null) {
            root.left = RemoveHalfNodes(root.left);
            root.right = RemoveHalfNodes(root.right);
        } else {
            if(root.left==null && root.right==null){
                return root;
            }else if (root.left != null) {
                return RemoveHalfNodes(root.left);
            } else {
                return RemoveHalfNodes(root.right);
            }
        }
        return root;
    }
}
