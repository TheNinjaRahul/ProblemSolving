package com.company.GFG.tree;

public class SumOfLeftLeafNodes {
    public static void main(String[] args) {

        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(7, new Node(6), new Node(9)));
        System.out.println(leftLeavesSum(root));
    }

    public static int leftLeavesSum(Node root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.right == null && root.left.left == null) {
            return root.left.data;
        }
        sum += leftLeavesSum(root.left);
        sum += leftLeavesSum(root.right);
        return sum;

    }
}
