package com.company.GFG.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {


    public static List<Integer> rightSideView(Node root) {

        List<Integer> list=new ArrayList<>();
        if(root==null) return list;
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count=queue.size();
            for(int i=0;i<count;i++){
                Node temp=queue.remove();
                if(i==count-1){
                    System.out.println(temp.data+" ");
                }
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }

        }
        return list;

    }
}
