package com.company.leetcode.tree;

import com.company.GFG.tree.ConvertLinkListToArray;

import java.util.Arrays;

public class SubtreeWithMaximumAverage {
    public static void main(String[] args) {

        SubtreeWithMaximumAverage sb = new SubtreeWithMaximumAverage();
        TreeNode[] child2 = new TreeNode[3];
        child2[0] = new TreeNode(11, new TreeNode[]{});
        child2[1] = new TreeNode(2, new TreeNode[]{});
        child2[2] = new TreeNode(3, new TreeNode[]{});


        TreeNode[] child1 = new TreeNode[2];
        child1[0] = new TreeNode(12, child2);
        child1[1] = new TreeNode(18, new TreeNode[]{new TreeNode(15, new TreeNode[]{}), new TreeNode(8, new TreeNode[]{})});

        TreeNode root = new TreeNode(20, child1);

        System.out.println(sb.maximumAverageSubtree(root).val);
    }

    static class TreeNode {
        int val;
        TreeNode[] childs;

        public TreeNode(int val, TreeNode[] childs) {
            this.val = val;
            this.childs = childs;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", childs=" + Arrays.toString(childs) +
                    '}';
        }
    }

    TreeNode maxNode = null;
    double globalAvg = Integer.MIN_VALUE;

    public TreeNode maximumAverageSubtree(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return maxNode;
    }

    private double[] helper(TreeNode root) {
        if (root == null) {
            return new double[]{0, 0};
        }
        double count = 1, sum = root.val;
        if (root.childs.length == 0) {
            return new double[]{count, sum};
        }
        for (int i = 0; i < root.childs.length; i++) {
            double[] result = helper(root.childs[i]);
            count += result[0];
            sum += result[1];
        }

        double avg = sum / count;
        if (globalAvg < avg) {
            globalAvg = avg;
            maxNode = root;
            System.out.println(maxNode);
            System.out.println("AVG:" + avg);
        }
        return new double[]{count, sum};
    }
}
