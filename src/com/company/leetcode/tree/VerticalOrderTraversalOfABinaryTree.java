package com.company.leetcode.tree;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = SerializationAndDeserialization.deserialize("[0,8,1,null,null,3,2,null,4,5,null,null,7,6]");
        VerticalOrderTraversalOfABinaryTree v = new VerticalOrderTraversalOfABinaryTree();
        System.out.println(v.verticalTraversal(root));

    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> output = new ArrayList<>();
        if (root == null) return output;
        List<int[]> points = new LinkedList<>();
        getData(root, 0, 0, points);

        Comparator<int[]> compare = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] == o2[2]) {
                    if (o1[1] == o2[1]) {
                        return o1[0] - o2[0];
                    } else {
                        return o1[1] - o2[1];
                    }
                } else {
                    return o1[2] - o2[2];
                }
            }
        };

        Collections.sort(points, compare);
        for (int i = 0; i < points.size(); i++) {
            System.out.println(Arrays.toString(points.get(i)));
        }
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < points.size(); i++) {
            List<Integer> list = new LinkedList<>();
            list.add(points.get(i)[0]);
            while (i + 1 < points.size() && points.get(i)[2] == points.get(i + 1)[2]) {
                list.add(points.get(i + 1)[0]);
                i++;
            }
            output.add(list);
        }

        return output;
    }

    public void getData(TreeNode root, int x, int y, List<int[]> points) {
        if (root == null) return;
        points.add(new int[]{root.val, x, y});
        getData(root.left, x + 1, y - 1, points);
        getData(root.right, x + 1, y + 1, points);
    }
}
