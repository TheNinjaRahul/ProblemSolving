package com.company.array;

public class CRISIL {


    /*
    3,4,10,2,1
    min:  3, 3, 3, 2,1 ,1
    max :10,10,10,9, 9,9
    o/p: 7

    Max diff: between two number such that higher number is after the lower number.

     */

    public static void main(String[] args) {
        int[] a = new int[]{3, 4, 10, 2, 1};
        System.out.println(maxDiff(a));
        System.out.println(maxDiff2(a));
    }

    public static int maxDiff(int[] a) {
        int minTillNow = a[0];
        int currentDiff = 0;
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            currentDiff = a[i] - minTillNow;
            minTillNow = Math.min(a[i], minTillNow);
            max = Math.max(currentDiff, max);
        }
        return max;
    }

    public static int maxDiff2(int[] a) {
        int[] mina = new int[a.length];
        int[] maxa = new int[a.length];

        mina[0] = a[0];
        maxa[a.length - 1] = a[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            mina[i] = Math.min(a[i], mina[i - 1]);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            maxa[i] = Math.max(a[i], maxa[i + 1]);
        }

        int ans = 0;
        for (int i = 0; i < a.length; i++) {
            ans = Math.max(ans, maxa[i] - mina[i]);
        }
        return ans;
    }
}
