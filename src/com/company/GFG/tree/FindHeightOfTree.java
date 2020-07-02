package com.company.GFG.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindHeightOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(maxDepth_bfs(root));

    }

    static int maxDepth_bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 0;
        while (!q.isEmpty()) {
            int currentSize = q.size();
            for (int i = 0; i < currentSize; i++) {
                TreeNode temp = q.poll();
                if (temp.left != null) q.add(temp.left);
                if (temp.right != null) q.add(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
