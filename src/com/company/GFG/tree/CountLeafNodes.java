package com.company.GFG.tree;

public class CountLeafNodes {
    int countLeaves(Node root)
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }
}
