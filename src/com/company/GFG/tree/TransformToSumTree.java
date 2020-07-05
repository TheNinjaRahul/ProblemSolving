package com.company.GFG.tree;

import com.company.util.Node;
public class TransformToSumTree {
    public static void main(String[] args) {
        Node root=DriverCode.buildTree("10 20 30 40 60");
        toSumTree(root);
//        TreeUtil.inOrderTraversal(root);
    }

    public static void toSumTree(Node root){
        if(root==null) return;
        root.data=getSum(root.left)+getSum(root.right);
    }

    private static int getSum(Node root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            int result=root.data;
            root.data=0;
            return result;
        }
        root.data=root.data+getSum(root.left)+getSum(root.right);
        return root.data;
    }
}
