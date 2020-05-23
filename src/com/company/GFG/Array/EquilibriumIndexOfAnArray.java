package com.company.GFG.Array;

public class EquilibriumIndexOfAnArray {

    public static void main(String[] args) {
        int[] data = {2,8, 4, 0, 6,8};
        System.out.println(find(data, data.length));
    }

    private static int find(int[] data, int n) {
        int i = 0, j = n - 1;
        int sum1 = data[i++], sum2 = data[j--];

        while (i < j) {
            if (sum1 < sum2) {
                sum1 += data[i++];
            } else {
                sum2 += data[j--];
            }
        }

        if (sum1==sum2) {
            return j;
        } else {
            return -1;
        }

    }
}
