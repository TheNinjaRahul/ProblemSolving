package com.company.leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {
    public static void main(String[] args) {

    }


    //Array Solution:
    public int rob(TreeNode root) {
        int[] res = rec(root);
        return Math.max(res[0], res[1]);
    }

    public int[] rec(TreeNode root) {
        if (root == null) return new int[2];
        int left[] = rec(root.left);
        int right[] = rec(root.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }


    //Dynamic Programming
    public int rob2(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        return rec2(root, map);
    }

    public int rec2(TreeNode root, Map<TreeNode, Integer> map) {

        if (root == null) return 0;
        if (map.containsKey(root)) return map.get(root);

        int val = 0;
        if (root.left != null) {
            val += rec2(root.left.left, map) + rec2(root.left.right, map);
        }
        if (root.right != null) {
            val += rec2(root.right.left, map) + rec2(root.right.right, map);
        }
        int ans = Math.max(val + root.val, rec2(root.left, map) + rec2(root.right, map));
        map.put(root, ans);
        return ans;
    }


}
