package com.company.Graph;

import java.util.*;

public class TreeEnigma {
    public static void main(String[] args) {

    }

    public static int enigma(TreeNode node1, TreeNode node2, boolean a) {
        if (node1 == null)
            return 0;
        if (!((node1.val ^ a) ^ node2.val))
            return enigma(node1.left, node2.left, a) + enigma(node1.right, node2.right, a);
        int b = 1 + enigma(node1.left, node2.left, a) + enigma(node1.right, node2.right, a);
        b = Math.min(b, 1 + enigma(node1.left, node2.right, !a) + enigma(node1.right, node2.right, !a));
        return b;
    }

    static int solve(int[] a, int[] b, boolean[] wrong, boolean[] right) {
        int n = wrong.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (map.containsKey(a[i]))
                map.get(a[i]).add(b[i]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(b[i]);
                map.put(a[i], list);
            }
            if (map.containsKey(b[i]))
                map.get(b[i]).add(a[i]);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(a[i]);
                map.put(b[i], list);
            }
        }
        List<TreeNode> vis1 = new ArrayList<>();
        List<TreeNode> vis2 = new ArrayList<>();
        vis1.add(new TreeNode(wrong[0]));
        vis2.add(new TreeNode(right[0]));
        Queue<Integer> q = new LinkedList<Integer>();
        List<Boolean> vis = new ArrayList<>();
        q.add(1);
        TreeNode temp1, temp2;
        while (!q.isEmpty()) {
            int root = q.poll();
            if (vis.get(root)) continue;
            vis.add(root, true);
            temp1 = vis1.get(root);
            temp2 = vis2.get(root);
            for (Integer i : map.get(root)) {
                if (!vis.get(i)) {
                    q.add(i);
                    vis1.add(i, new TreeNode(wrong[i - 1]));
                    vis2.add(i, new TreeNode(right[i - 1]));
                    if (temp1.left != null) {
                        temp1.right = vis1.get(i);
                        temp2.right = vis2.get(i);
                    } else {
                        temp1.left = vis1.get(i);
                        temp2.left = vis2.get(i);
                    }
                }
            }
        }
        return enigma(vis1.get(1), vis2.get(1), false);
    }

    static class TreeNode {
        TreeNode left, right;
        boolean val;

        TreeNode(boolean x) {
            this.val = x;
        }
    }

}
