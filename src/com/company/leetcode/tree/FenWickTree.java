package com.company.leetcode.tree;

public class FenWickTree {
    int[] bit;

    FenWickTree(int size) {
        this.bit = new int[size + 1];
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 3};
        FenWickTree f = new FenWickTree(a.length);
        for (int i = 0; i < a.length; i++) {
            f.update(i + 1, a[i]);
        }
        System.out.println(f.sum(7));
    }

    private void update(int i, int x) {
        for (; i < bit.length; i += (i & -i)) {
            bit[i] += x;
        }
    }


    private int sum(int i) {
        int ans = 0;
        for (; i > 0; i -= (i & -i)) {
            ans += bit[i];
        }
        return ans;
    }

}
