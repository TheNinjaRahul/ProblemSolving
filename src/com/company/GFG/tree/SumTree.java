package com.company.GFG.tree;

public class SumTree {
    public static void main(String[] args) {

    }

    boolean isSumTree(Node node)
    {
        if(node==null || (node.left==null && node.right==null)) return true;

        int left=sum(node.left);
        int right=sum(node.right);
        return (left+right==node.data && isSumTree(node.left) && isSumTree(node.right));

    }

    private int sum(Node root) {
        if(root==null) return 0;
        return sum(root.left)+sum(root.right)+root.data;
    }
}
