package com.company.GFG.BST;

public class ConvertToGreaterTree {
    public static void main(String[] args) {
        
    }

    static class Myclass {
        int data = 0;
    }

    public  Node convertBST(Node root) {
        Myclass my = new Myclass();
        getAlldataues(my, root);
        return root;
    }

    private static void getAlldataues(Myclass my, Node root) {
        if (root == null) return;
        getAlldataues(my, root.right);
        root.data += my.data;
        my.data = root.data;
        getAlldataues(my, root.left);
    }
}
