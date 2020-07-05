package com.company.GFG.tree;

import java.util.*;

public class SerializeDeserialize {
    public static void main(String[] args) {
        
    }

    public static String serialize(Node root) {
        if (root == null) return null;
        LinkedList<Integer> list = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.peek() == null) {
                    list.add(null);
                    queue.remove();
                    continue;
                }
                Node temp = queue.remove();
                list.add(temp.data);
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
    public static Node deserialize(String data) {
        if (data == null) return null;
        List<String> myList = new ArrayList<String>(Arrays.asList(data.split(",")));
        if (myList.size() == 1 && myList.get(0).equals("")) return null;

        myList.set(0, myList.get(0).replace('[', ' '));
        myList.set(myList.size() - 1, myList.get(myList.size() - 1).replace(']', ' '));

        List<Integer> list = collectStringToInteger(myList);
        Node root = new Node(list.get(0));

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int i=1;
        while(!queue.isEmpty()){
            Node temp=queue.remove();
            if(temp!=null){
                if(i<list.size() && list.get(i)!=null){
                    temp.left= new Node(list.get(i));
                }
                i++;
                if(i<list.size() && list.get(i)!=null){
                    temp.right= new Node(list.get(i));
                }
                i++;
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }

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
