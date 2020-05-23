package com.company.GFG.Array;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

public class MaxPathSum {
    public static void main(String[] args) {
        int data1[] = {2, 3, 7, 10, 12};
        int data2[] = {1, 5, 7, 8};
        System.out.println(maxPathSum2(data1, data2));
//        System.out.println(maxPathSum(data1,data2));
    }

    // Merge sort solution
    private static int maxPathSum2(int[] ar1, int[] ar2) {
        int sum1 = 0, sum2 = 0, i = 0, j = 0, result = 0;
        while (i < ar1.length && j < ar2.length) {

            if (ar1[i] < ar2[j]) {
                sum1 += ar1[i++];
            } else if (ar1[i] > ar2[j]) {
                sum2 += ar2[j++];
            } else {
                result += ar1[i++] + Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                j++;
            }
        }

        while(i<ar1.length)
            sum1+=ar1[i++];
        while(j<ar2.length)
            sum2+=ar2[j++];

        return result+ Math.max(sum1,sum2);
    }

        public static int maxPathSum ( int ar1[], int ar2[]){
            if (ar1.length == 0 && ar2.length == 0) {
                return 0;
            }

            int sum1 = 0, sum2 = 0;
            if (ar1.length == 0) {
                for (int i = 0; i < ar2.length; i++) {
                    sum2 += ar2[i];
                    return sum2;
                }
            }

            if (ar2.length == 0) {
                for (int i = 0; i < ar1.length; i++) {
                    sum1 += ar1[i];
                    return sum1;
                }
            }
            int i = 0;

            while (i < ar1.length && i < ar2.length) {
                sum1 += ar1[i];
                sum2 += ar2[i];
                if (ar1[i] == ar2[i]) {
                    sum1 += Math.max(maxPathSum(Arrays.copyOfRange(ar1, i + 1, ar1.length), Arrays.copyOfRange(ar2, i + 1, ar2.length)), maxPathSum(Arrays.copyOfRange(ar2, i + 1, ar2.length), Arrays.copyOfRange(ar1, i + 1, ar1.length)));
                    sum2 += Math.max(maxPathSum(Arrays.copyOfRange(ar1, i + 1, ar1.length), Arrays.copyOfRange(ar2, i + 1, ar2.length)), maxPathSum(Arrays.copyOfRange(ar2, i + 1, ar2.length), Arrays.copyOfRange(ar1, i + 1, ar1.length)));
                    return Math.max(sum1, sum2);
                }
                i++;
            }

            if (ar1.length == i) {
                for (int j = i; j < ar2.length; j++) {
                    sum2 += ar2[j];
                }
            }

            if (ar2.length == i) {
                for (int j = i; j < ar1.length; j++) {
                    sum1 += ar1[i];
                }
            }

            return Math.max(sum1, sum2);
        }
    }
