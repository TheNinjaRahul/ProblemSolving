package com.company.GFG.tree;

public class NumberOfTurnsInBinaryTree {


    public static void main(String[] args) {
        Node root = DriverCode.buildTree("1 2 3 4 5 6 7 8 N N N 9 10 N N");
        System.out.println(NumberOfTurns(root, 5, 9));
    }

    static class MyClass {
        int count = 0;
    }

    static int NumberOfTurns(Node root, int first, int second) {
        Node common = lowestCommonAncestor(root, first, second);
        if (common == null) return -1;

        MyClass count = new MyClass();
        if (root.data != first && root.data != second) {
            findTurn(root.left, true, first, second, count);
            if (findTurn(root.right, false, first, second, count)) {
                count.count++;
            }
        }

        return count.count != 0 ? count.count : -1;
    }

    private static boolean findTurn(Node root, boolean turn, int first, int second, MyClass count) {
        if (root == null) return false;
        if (root.data == first || root.data == second) {
            return true;
        }

        if (turn) {
            if (findTurn(root.left, turn, first, second, count)) return true;
            if (findTurn(root.right, !turn, first, second, count)) {
                count.count++;
                return true;
            }
        } else {
            if (findTurn(root.right, turn, first, second, count)) return true;
            if (findTurn(root.left, !turn, first, second, count)) {
                count.count++;
                return true;
            }
        }
        return false;
    }


    public static Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null) return null;
        if (root.data == p || root.data == q) return root;
        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;
        return null;
    }
}
