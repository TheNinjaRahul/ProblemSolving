package com.company.GFG.Array;

import java.util.ArrayList;

public class FindMinDistance {
    public static void main(String[] args) {
//        long[] data = {2,4,6,2,4,6,2,6};//{96l, 82l, 48l, 76l, 34l, 19l, 7l, 80l, 36l, 57l, 77l, 34l, 19l, 35l, 5l, 57l, 16l, 66l, 42l, 62l, 89l, 19l, 60l, 19l, 25l, 16l, 20l, 51l, 77l, 75l, 12l, 73l, 8l, 11l, 100l, 93l, 81l, 58l, 72l, 17l, 14l, 48l, 2l, 33l, 82l, 6l, 41l, 49l, 72l, 34l, 10l, 12l, 53l, 21l, 30l, 77l, 36l, 49l, 79l, 13l, 75l, 42l};
//        System.out.println(minDist(data, data.length, 36, 33));
//        long [] data={13l,98l,5l,10l,23l,13l,4l,53l,60l,78l,66l,68l,44l,69l,79l,71l,90l,17l,91l,84l,34l,52l,12l,11l,57l,61l,2l};
//        System.out.println(minDist(data, data.length, 78l, 68l));
////
//        long [] data2={1l,2l};
//        System.out.println(minDist(data2,data2.length,1l,2l));
//
        long[] data3 = {86l, 39l, 90l, 67l, 84l, 66l, 62l};
        System.out.println(minDist(data3, data3.length, 42l, 12l));


    }

    public static long minDist(long arr[], long n, long x, long y) {
        int f = -1, l = -1;
        long count = Long.MAX_VALUE;
        ;
        for (int i = 0; i < n; i++) {
            f = arr[i] == x ? i : f;
            l = arr[i] == y ? i : l;

            if (f >= 0 && l >= 0)
                count = Math.min(count, Math.abs(f - l));
        }

        if (count <= 0 || count == Long.MAX_VALUE) return -1;
        return count;
    }
}
