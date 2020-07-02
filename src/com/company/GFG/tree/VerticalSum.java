package com.company.GFG.tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Map<Integer,Integer> map=new TreeMap<>();
        map.put(0,root.data);
        getSum(map,root.left,-1);
        getSum(map,root.right,1);
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            list.add(e.getValue());
        }
        return list;
    }

    private void getSum(Map<Integer, Integer> map, Node root, int hn) {
        if(root==null) return;
        if(map.containsKey(hn)){
            map.put(hn,map.get(hn)+root.data);
        }else{
            map.put(hn,root.data);
        }
        getSum(map,root.left,hn-1);
        getSum(map,root.right,hn+1);
    }
}
