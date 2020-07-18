package com.company.GFG.BST;

public class FindTheClosestElementInBinarySearchTree {
    public static void main(String[] args) {
        Node root2 = DriverCode.buildTree("5 2 9 1 3 7 N N N N 4 6 8");
        System.out.println(maxDiff(root2, 7));

        Node root = DriverCode.buildTree("10 2 11 1 5 N N N N 3 6 N 4");
        System.out.println(maxDiff(root, 13));
    }

    static int maxDiff(Node root, int K) {
        if (root == null) return Integer.MAX_VALUE;

        if (root.data == K) {
            return 0;
        }

        if (root.data < K) {
            return Math.min(Math.abs(root.data - K), maxDiff(root.right, K));
        }

        return Math.min(Math.abs(root.data - K), maxDiff(root.left, K));
    }

    static class Myclass {
        int min = Integer.MAX_VALUE;
    }

    static int maxDiff2(Node root, int K) {
        Myclass myclass = new Myclass();
        getMin(root, K, myclass);
        return myclass.min;
    }

    private static void getMin(Node root, int K, Myclass myclass) {
        if (root == null) return;
        if (root.data == K) {
            myclass.min = 0;
            return;
        }

        if (root.data < K) {
            if (K - root.data >= 0) {
                myclass.min = Math.min(myclass.min, K - root.data);
                getMin(root.right, K, myclass);
            }
        } else {
            if (root.data - K >= 0) {
                myclass.min = Math.min(myclass.min, root.data - K);
                getMin(root.left, K, myclass);
            }
        }
    }


}
