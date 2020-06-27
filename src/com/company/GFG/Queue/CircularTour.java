package com.company.GFG.Queue;

import java.util.LinkedList;

public class CircularTour {
    public static void main(String[] args) {
        int[] p = {6, 6, 7, 4};
        int d[] = {6, 5, 3, 5};
        System.out.println(tour(p, d));
    }

    LinkedList<String> data=new LinkedList<>();

    static int tour(int petrol[], int distance[]) {
        for (int i = 0; i < petrol.length; i++) {
            if (checkWithIth(petrol, distance, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean checkWithIth(int[] petrol, int[] distance, int i) {
        int d = 0, c = 0;
        for (int k = 0; k != petrol.length; k++) {
            c += petrol[i];
            if (distance[i] <= c) {
                c -= distance[i];
            }else {
                return false;
            }
            i = (i + 1) % petrol.length;
        }
        return true;
    }
}
