package com.company.BTree;

public class BTreeOperation {
    public static void main(String[] args) {
        BTREE tree=new BTREE();
        tree.add(5);
        tree.add(2);
        tree.add(1);
        tree.add(3);tree.add(7);
        tree.add(6);tree.add(8);

        System.out.println("In Order .....");
        printInorder(tree.root);

        System.out.println("Pre Order .....\n");
        printPreorder(tree.root);

        System.out.println("Post Order .....\n");
        printPostorder(tree.root);

    }

    private static void printInorder(BTreeNode root) {
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    private static void printPostorder(BTreeNode root) {
        if(root==null){
            return;
        }
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data+" ");
    }

    private static void printPreorder(BTreeNode root) {
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        printPreorder(root.left);
        printPreorder(root.right);
    }
}
