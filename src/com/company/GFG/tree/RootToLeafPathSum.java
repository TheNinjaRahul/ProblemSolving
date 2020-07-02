package com.company.GFG.tree;

public class RootToLeafPathSum {
    public static void main(String[] args) {

    }

    boolean hasPathSum(Node node, int sum) {
        if(node==null) return false;
        if(node.left==null && node.right==null && node.data-sum==0) return true;
        return hasPathSum(node.left,sum-node.data) || hasPathSum(node.right,sum-node.data);
    }
}
