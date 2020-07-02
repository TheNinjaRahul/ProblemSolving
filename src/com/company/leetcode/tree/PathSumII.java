package com.company.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),
                new TreeNode(8,new TreeNode(13),new TreeNode(4,new TreeNode(5),new TreeNode(1))));
        System.out.println(pathSum(root,22));
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;


        List<List<Integer>> left = pathSum(root.left, sum - root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);

        if(root.right==null && root.left==null){
            if(root.val-sum==0){
                List<Integer> singleNodeList=new LinkedList<>();
                singleNodeList.add(root.val);
                list.add(singleNodeList);
                return list;
            }else{
                return list;
            }
        }

        for (List<Integer> leftList : left) {
            if ((leftList.stream().reduce(0, (a, b) -> a + b)+root.val) == sum) {
                leftList.add(0,root.val);
                list.add(leftList);
            }
        }

        for (List<Integer> rightList : right) {
            if ((rightList.stream().reduce(0, (a, b) -> a + b)+root.val) == sum) {
                rightList.add(0,root.val);
                list.add(rightList);
            }
        }
        return list;
    }
}
