package com.company.BTree;

public class BTREE{
    BTreeNode root;

    public void add(int data){
        BTreeNode n=new BTreeNode(data);
        if(root==null){
            root=n;
            return;
        }
        else{
            insert(root,n);
        }
    }

    private BTreeNode insert(BTreeNode root, BTreeNode n) {
        if(root==null){
            return n;
        }
        if(root.data>n.data){
            root.left=insert(root.left,n);
            return root;
        }else{
            root.right=insert(root.right,n);
            return root;
        }

    }


}
