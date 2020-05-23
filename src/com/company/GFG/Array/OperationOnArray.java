package com.company.GFG.Array;

public class OperationOnArray {

    public static void main(String[] args) {
        int data[] = {127, 504, 629, 49, 964, 285, 429, 343, 335, 177, 900, 238, 971, 949, 289, 367};
        System.out.println(searchEle(data, 988));
        System.out.println(insertEle(data, 292, 3));
        System.out.println(deleteEle(data, 743));
    }


    public static boolean searchEle(int a[], int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return true;
        }
        return false;
    }

    public static boolean insertEle(int a[], int y, int yi) {
        if (yi < a.length && yi > -1) {
            a[yi] = y;
            return true;
        }
        return false;
    }

    public static boolean deleteEle(int a[], int z) {
        int index = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == z) {
                index = i;
                if (!(index < 0)) {
                    for (int k = index; k < a.length - 1; k++) {
                        a[k] = a[k + 1];
                    }

                }
            }
        }

        return true;

    }

}
