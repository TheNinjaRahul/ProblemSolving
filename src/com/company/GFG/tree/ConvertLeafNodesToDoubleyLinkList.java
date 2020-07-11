package com.company.GFG.tree;

public class ConvertLeafNodesToDoubleyLinkList {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("1 2 3 4 5 6 7");
        System.out.println(convertToDLL(root));
    }

    static class myRes {
        Node dlHead = new Node(1);
        Node temp = dlHead;
    }

    public static Node convertToDLL(Node root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return root;
        myRes dllhead = new myRes();
        getAllLeaf(root, dllhead);

        Node res=dllhead.dlHead.right;
        res.left=null;
        return res;
    }

    private static Node getAllLeaf(Node root, myRes dllhead) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            dllhead.temp.right = root;
            root.left=dllhead.temp;
            dllhead.temp = dllhead.temp.right;
            return null;
        }

        if (root.left != null) {
            root.left = getAllLeaf(root.left, dllhead);
        }
        if (root.right != null) {
            root.right = getAllLeaf(root.right, dllhead);
        }
        return root;
    }
}
