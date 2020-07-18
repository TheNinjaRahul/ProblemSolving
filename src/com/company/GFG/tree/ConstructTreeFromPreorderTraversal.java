package com.company.GFG.tree;

public class ConstructTreeFromPreorderTraversal {
    public static void main(String[] args) {
        int[] data = {10, 30, 20, 5, 15};
        char[] chars = {'N', 'N', 'L', 'L', 'L'};


        int data2[] = {1, 2, 4, 3};
        char chars2[] = {'N', 'N', 'L', 'L'};
//        Node root = constructTree(0, data, chars);
//        TreeUtil.inOrderTraversal(root);
        Node root2 = constructTree(5, data2, chars2);
        TreeUtil.inOrderTraversal(root2);
    }

    static class myclass {
        int currentInex = 0;
    }

    static Node constructTree(int n, int pre[], char preLN[]) {
        myclass index = new myclass();
        Node root = createTree(pre, preLN, index);
        return root;
    }

    private static Node createTree(int[] pre, char[] preLN, myclass index) {
        if (index.currentInex > pre.length) return null;
        Node root = new Node(pre[index.currentInex]);
        index.currentInex++;
        if (preLN[index.currentInex] != 'L') {
            root.left = createTree(pre, preLN, index);
        } else {
            root.left = new Node(pre[index.currentInex]);
        }
        index.currentInex++;
        if (index.currentInex > pre.length-1) return root;
        if (preLN[index.currentInex] != 'L') {
            root.right = createTree(pre, preLN, index);
        } else {
            root.right = new Node(pre[index.currentInex]);
        }
        return root;
    }
}
