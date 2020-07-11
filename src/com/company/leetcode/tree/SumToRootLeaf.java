package com.company.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SumToRootLeaf {
    public static void main(String[] args) {
    }

    public int sumRootToLeaf(TreeNode root) {
        List<String> list = new LinkedList<>();
        String s = String.valueOf(root.val);
        getAllData(s, list, root.left);
        getAllData(s, list, root.right);

        System.out.println(list);
        int result=0;

        for(String str:list){
            int sum=0;
            int twopow=0;
            for(int i=str.length()-1;i>=0;i--){
                if(str.charAt(i)=='1'){
                    sum+= Math.pow(2,twopow);
                }
                twopow++;
            }
            result+=sum;
        }

        return result;
    }

    private void getAllData(String s, List<String> list, TreeNode root) {
        if (root == null) return;
        s += String.valueOf(root.val);
        if (root.left == null && root.right == null) {
            list.add(s);
            return;
        }
        getAllData(s, list, root.left);
        getAllData(s, list, root.right);
    }
}
