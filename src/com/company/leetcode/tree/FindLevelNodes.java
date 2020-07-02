package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLevelNodes {
    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = 0;
        int level = 0;
        while (!queue.isEmpty()) {
            int currentCout = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentCout; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                list.add(temp.val);
            }
           output.add(list);
            level++;
        }
        return output;
    }
}
