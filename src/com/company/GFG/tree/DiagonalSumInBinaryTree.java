package com.company.GFG.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DiagonalSumInBinaryTree {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> diagonalSum(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Map<Integer, Integer> map=new TreeMap<>();
        map.put(0,map.getOrDefault(0,0)+root.data);
        getDiagonalSum(root.left,map,1);
        getDiagonalSum(root.right,map,0);
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }

    private static void getDiagonalSum(Node root, Map<Integer, Integer> map, int diagonalNum) {
        if(root==null) return;
        map.put(diagonalNum,map.getOrDefault(diagonalNum,0)+root.data);
        getDiagonalSum(root.left,map,diagonalNum+1);
        getDiagonalSum(root.right,map,diagonalNum);
    }
}
