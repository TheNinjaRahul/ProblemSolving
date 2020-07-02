package com.company.leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class IsCousins {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(1,new TreeNode(2,null,new TreeNode(4)),new TreeNode(3));
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(8,new TreeNode(9),null),new TreeNode(3)),
                new TreeNode(5,null,new TreeNode(7,new TreeNode(4,null,new TreeNode(6)),null)));


        System.out.println(isCousins2(root,9,4));
    }

    public static boolean isCousins2(TreeNode root, int x, int y) {
        Map<Integer, Integer> levelMap = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        dfs(root, null, levelMap, parentMap);

//        System.out.println(levelMap);
//        System.out.println(parentMap);
        if (levelMap.get(x) == levelMap.get(y) && parentMap.get(x) != parentMap.get(y)) {
            return true;
        }
        return false;
    }

    private static void dfs(TreeNode root, TreeNode parent, Map<Integer, Integer> levelMap, Map<Integer, TreeNode> parentMap) {
        if (root == null) return;
        int parentLevel = parent == null ? 0 : levelMap.get(parent.val);
        levelMap.put(root.val, parentLevel + 1);
        parentMap.put(root.val, parent);
        dfs(root.left, root, levelMap, parentMap);
        dfs(root.right, root, levelMap, parentMap);
    }

    

}
