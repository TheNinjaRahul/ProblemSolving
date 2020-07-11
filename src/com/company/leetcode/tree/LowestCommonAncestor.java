package com.company.leetcode.tree;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root=SerializationAndDeserialization.deserialize("[6,2,8,0,4,7,9,null,null,3,5]");
        TreeNode result=lowestCommonAncestor(root,new TreeNode(3),new TreeNode(9));
        System.out.println(lowestCommonAncestor(root,new TreeNode(3),new TreeNode(9)));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val==p.val||root.val==q.val) return root;
        TreeNode left= lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        if(right!=null) return right;
        return null;
    }
}
