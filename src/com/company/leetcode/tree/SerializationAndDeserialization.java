package com.company.leetcode.tree;

import java.util.*;
import java.util.stream.Collectors;

public class SerializationAndDeserialization {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
//        String s = serialize(root);
//        deserialize(s);
        TreeNode t1 = deserialize("[5,2,3,null,null,2,4,3,1]");
//        deserialize("");
        System.out.println();
    }

    public static String serialize(TreeNode root) {
        if (root == null) return null;
        LinkedList<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek() == null) {
                    list.add(null);
                    queue.remove();
                    continue;
                }
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if (temp.left != null) {
                    queue.add(temp.left);
                } else queue.add(null);
                if (temp.right != null) {
                    queue.add(temp.right);
                } else queue.add(null);
                ;
            }
        }
        removeLastNull(list);
        System.out.println(list);
        return list.toString();
    }

    private static void removeLastNull(LinkedList<Integer> list) {
        while (list.getLast() == null) {
            list.removeLast();
        }
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == null) return null;
        List<String> myList = new ArrayList<String>(Arrays.asList(data.split(",")));
        if (myList.size() == 1 && myList.get(0).equals("")) return null;

        myList.set(0, myList.get(0).replace('[', ' '));
        myList.set(myList.size() - 1, myList.get(myList.size() - 1).replace(']', ' '));

        List<Integer> list = collectStringToInteger(myList);
        TreeNode root = new TreeNode(list.get(0));

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
               TreeNode temp=queue.remove();
               if(temp!=null){
                   if(i<list.size() && list.get(i)!=null){
                        temp.left= new TreeNode(list.get(i));
                   }
                   i++;
                   if(i<list.size() && list.get(i)!=null){
                       temp.right= new TreeNode(list.get(i));
                   }
                   i++;
                   queue.add(temp.left);
                   queue.add(temp.right);
               }
        }
//        System.out.println(myList);
//        System.out.println(list);
        return root;
    }

    private static TreeNode getRightChild(List<Integer> list, int parentIndex) {
        int index = (parentIndex * 2) + 2;
        if (index >= list.size()) {
            return null;
        }

        if (list.get(index) == null) return null;

        TreeNode root = new TreeNode(list.get(index));
        root.left = getLeftChild(list, index);
        root.right = getRightChild(list, index);
        return root;
    }

    private static TreeNode getLeftChild(List<Integer> list, int parentIndex) {
        int index = (parentIndex * 2) + 1;
        if (index >= list.size()) {
            return null;
        }

        if (list.get(index) == null) return null;

        TreeNode root = new TreeNode(list.get(index));
        root.left = getLeftChild(list, index);
        root.right = getRightChild(list, index);
        return root;
    }

    private static List<Integer> collectStringToInteger(List<String> myList) {
        List<Integer> list = new LinkedList<>();
        if (myList.size() == 0) return list;
        for (String s : myList) {
            if (s.trim().equals("null")) {
                list.add(null);
                continue;
            }
            list.add(Integer.parseInt(s.trim()));
        }
        return list;
    }
}
