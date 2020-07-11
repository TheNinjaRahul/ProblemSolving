package com.company.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindMaxWidthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(widthOfBinaryTree(root));
    }


    public static int widthOfBinaryTree(TreeNode root) {
        Map<Integer, Integer[]> map = new HashMap<>();
        generateValues(root, 0, 1, map);
        int ans = 0;
        for (Integer[] values : map.values()) {
            ans = Math.max(ans, values[1] - values[0] + 1);
        }
        return ans;
    }

    private static void generateValues(TreeNode root, int row, int position, Map<Integer, Integer[]> map) {

        if (root == null) return;
        Integer[] current = map.getOrDefault(row, new Integer[2]);
        if (current[0] == null || current[0] > position) current[0] = position;
        if (current[1] == null || current[1] < position) current[1] = position;
        map.put(row, current);
        generateValues(root.left, row + 1, position * 2 - 1, map);
        generateValues(root.right, row + 1, position * 2 , map);
    }

    static class MyPair {
        TreeNode node;
        int position;

        public MyPair(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public static int widthOfBinaryTree2(TreeNode root) {
        int ans = 0;
        Queue<MyPair> queue = new LinkedList<>();
        queue.add(new MyPair(root, 0));
        while (queue.isEmpty()) {
            int size = queue.size();
            int begin = 0, end = 0;
            for (int i = 0; i < size; i++) {
                MyPair current = queue.remove();
                if (i == 0) {
                    begin = current.position;
                }
                if (i == size - 1) {
                    end = current.position;
                    ans = Math.max(ans, end - begin + 1);
                }

                if (current.node.left != null) queue.add(new MyPair(current.node.left, current.position * 2 - 1));
                if (current.node.right != null) queue.add(new MyPair(current.node.right, current.position * 2));
            }
        }
        return ans;
    }
}
