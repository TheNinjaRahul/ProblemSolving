package com.company.leetcode.tree;


import com.company.GFG.tree.ConvertLinkListToArray;

import java.util.*;
import java.util.stream.Collectors;

public class AllNodesDistanceKInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = SerializationAndDeserialization.deserialize("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode target = new TreeNode(5);
        System.out.println(distanceK(root, target, 1));
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new LinkedList<>();

        if (root == null || target == null || K < 0) return list;
        if(K==0){
            list.add(target.val);
            return list;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        getAllParent(root, parentMap);
//        getAllParent(root.right, parentMap);
        Set<TreeNode> set = new HashSet<>();
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        target = findTarget(root, target);
        set.add(target);
        queue.add(target);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.remove();
                if (temp.left != null && !set.contains(temp.left)) {
                    queue.add(temp.left);
                    set.add(temp.left);
                }
                if (temp.right != null && !set.contains(temp.right)) {
                    queue.add(temp.right);
                    set.add(temp.right);
                }
                if (parentMap.get(temp) != null && !set.contains(parentMap.get(temp))) {
                    queue.add(parentMap.get(temp));
                    set.add(parentMap.get(temp));
                }
            }
            if (level + 1 == K) {
                while (!queue.isEmpty()) {
                    list.add(queue.poll().val);
                }
            }
            level++;
        }
        return list;
    }

    private static TreeNode findTarget(TreeNode root, TreeNode target) {
        if (root == null) return null;
        if (root.val == target.val) return root;
        TreeNode left = findTarget(root.left, target);
        TreeNode right = findTarget(root.right, target);
        return left != null ? left : right;
    }

    private static void getAllParent(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root == null) return;
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        getAllParent(root.left, map);
        getAllParent(root.right, map);
    }

}