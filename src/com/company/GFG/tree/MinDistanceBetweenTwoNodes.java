package com.company.GFG.tree;

public class MinDistanceBetweenTwoNodes {
    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3, new Node(4), new Node(5)));
        System.out.println(findDist(root, 3, 2));
    }

    static int findDist(Node root, int a, int b) {
        Node common = lca(root, a, b);
        int aDist = findDistSingle(common, a, 0);
        int bDist = findDistSingle(common, b, 0);
        return aDist + bDist;
    }

    private static Node lca(Node root, int p, int q) {
        if (root == null) return null;
        if (root.data == p || root.data == q) return root;
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }

    private static int findDistSingle(Node root, int val, int level) {
        if (root == null) return 0;
        if (root.data == val) return level;
        int left = findDistSingle(root.left, val,level+1);
        if(left!=0){
            return left;
        }
        int right = findDistSingle(root.right, val,level+1);
        return right;
    }
}
