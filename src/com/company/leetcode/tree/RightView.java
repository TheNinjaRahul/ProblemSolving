package com.company.leetcode.tree;

import java.util.*;

public class RightView {
    public static void main(String[] args) {
//        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            for(int i=0;i<count;i++){
                TreeNode temp=queue.remove();
                if(i==count-1){
                    list.add(temp.val);
                }
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }

        }
        return list;

    }
}
