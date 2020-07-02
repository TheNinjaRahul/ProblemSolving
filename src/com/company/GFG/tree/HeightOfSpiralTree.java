package com.company.GFG.tree;

public class HeightOfSpiralTree {
    public static void main(String[] args) {

    }
    public static int findTreeHeight(Node root)
    {
        if(root==null) return 0;
        if(root.right!=null && root.right.left==root &&root.left!=null&& root.left.right==root){
            return 1;
        }
        return Math.max(1+findTreeHeight(root.left),1+findTreeHeight(root.right));
    }
}
