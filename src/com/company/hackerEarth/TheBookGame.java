package com.company.hackerEarth;

public class TheBookGame {

    static int mod = 1000000007;

    public static void main(String[] args) {

    }

    public static int max(int[] a, int i, int ans) {
        if (i >= a.length) return ans;
        return Math.max(max(a, i + 1, (ans * (a[i] % 10)) % mod),
                max(a, i + 1, (ans + (a[i] % 10)) % mod));
    }
}
