package com.company.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderOfTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println(verticalTraversalRec(root));
    }

    static class VerticalResult{
        int val;
        int level;

        public VerticalResult(int val, int level) {
            this.val = val;
            this.level = level;
        }

        @Override
        public String toString() {
            return "VerticalResult{" +
                    "val=" + val +
                    ", level=" + level +
                    '}';
        }
    }


    public static List<List<Integer>> verticalTraversalRec(TreeNode root) {
        List<List<Integer>> output=new ArrayList<>();
        if(root==null) return output;
        Map<Integer,List<VerticalResult>> map=new TreeMap<>();
        List<VerticalResult> list=new ArrayList<>();
        list.add(new VerticalResult(root.val,0));
        map.put(0,list);
        getAllVerticalNodesOfRoot(root.left,-1,map,1);
        getAllVerticalNodesOfRoot(root.right,1,map,1);
        System.out.println(map);
        Comparator<VerticalResult> levelComparator=new Comparator<VerticalResult>() {
            @Override
            public int compare(VerticalResult o1, VerticalResult o2) {
                return o1.level-o2.level;
            }
        };
        for(Map.Entry<Integer,List<VerticalResult>> e:map.entrySet()){
            List<VerticalResult> values=e.getValue();
            Collections.sort(values,levelComparator);
            output.add(values.stream().map(a->a.val).collect(Collectors.toList()));
        }
        return output;
    }


    private static void getAllVerticalNodesOfRoot(TreeNode root, int vn, Map<Integer, List<VerticalResult>> map, int level) {
        if(root==null) return;
        if(map.containsKey(vn)){
            map.get(vn).add(new VerticalResult(root.val,level));
        }else{
            List<VerticalResult> list=new ArrayList<>();
            list.add(new VerticalResult(root.val,level));
            map.put(vn,list);
        }
        getAllVerticalNodesOfRoot(root.left,vn-1,map, level+1);
        getAllVerticalNodesOfRoot(root.right,vn+1,map, level+1);
    }
}
