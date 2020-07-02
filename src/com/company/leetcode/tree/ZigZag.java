package com.company.leetcode.tree;

import java.util.*;

public class ZigZag {
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1,new TreeNode(2,new TreeNode(4),new TreeNode(5)),new TreeNode(3,new TreeNode(6),new TreeNode(7)));
        System.out.println(zigzagLevelOrder(root));
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new LinkedList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        boolean rightToLeft=true;
        while(!queue.isEmpty()){
            if(rightToLeft){
                List<Integer> mini=new LinkedList<>();
                int size= queue.size();
                for(int i=0;i<size;i++){
                    TreeNode temp=queue.pollLast();
                    mini.add(temp.val);
                    if(temp.right!=null) queue.addFirst(temp.right);
                    if(temp.left!=null) queue.addFirst(temp.left);
                }
                list.add(mini);
            }else {
                int size= queue.size();
                List<Integer> mini=new LinkedList<>();
                for(int i=0;i<size;i++){
                    TreeNode temp=queue.pollFirst();
                    mini.add(temp.val);
                    if(temp.left!=null) queue.addLast(temp.left);
                    if(temp.right!=null) queue.addLast(temp.right);
                }
                list.add(mini);
            }
            rightToLeft=!rightToLeft;
        }
        return list;
    }
}

