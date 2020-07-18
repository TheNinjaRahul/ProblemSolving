package com.company.GFG.tree;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Node root = DriverCode.buildTree("1 2 3");
        System.out.println(longestConsecutive(root));

        Node root2 = DriverCode.buildTree("10 20 30 40 60 90");
        System.out.println(longestConsecutive(root2));

        Node root3 = DriverCode.buildTree("29 31 30 28 N 29 29 30 31 N 30 31 31 30");
        System.out.println(longestConsecutive(root3));

        Node root4 = DriverCode.buildTree("26 23 26 24 N 25 25 25 26 N 26");
        System.out.println(longestConsecutive(root4));
    }

    static class myclass {
        int max = 1;
    }

    public static int longestConsecutive(Node root) {
        myclass max = new myclass();
        findMax(root, root.left, max, 1);
        findMax(root, root.right, max, 1);
        return max.max == 1 ? -1 : max.max;
    }

    private static void findMax(Node root, Node childNOde, myclass max, int consecutivePath) {
        if (root == null || childNOde == null) return;

        if (root.data + 1 == childNOde.data) {
            consecutivePath++;
            max.max = Math.max(consecutivePath, max.max);
            findMax(childNOde, childNOde.left, max, consecutivePath);
            findMax(childNOde, childNOde.right, max, consecutivePath);
        } else {
            consecutivePath = 1;
            findMax(childNOde, childNOde.left, max, consecutivePath);
            findMax(childNOde, childNOde.right, max, consecutivePath);
        }
    }
}
