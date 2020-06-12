package com.company.GFG.String;

/***
 * Compare Version Number
 * Given two non-empty strings v1 and v2 denoting two version numbers. These strings can only contain digits or the '.' character which is used to separate number sequences. You need to compare the strings v1 and v2.
 *
 * Input:
 * The first line of input contains the number of test cases T. For each test case, there will be two lines containing v1 and v2.
 *
 * Output:
 * Return 1 if v1 > v2.
 * Return -1 if v1 < v2.
 * Return 0 otherwise.
 *
 * User Task:
 * The task is to complete the function VersionCompare that takes v1 and v2 as arguments and returns an integer value.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= v1.length, v2.length <= 30
 *
 * Example:
 * Input :
 * 3
 * 0.2
 * 1.0
 * 1.0.1
 * 1
 * 2.01
 * 2.001
 * Output :
 * -1
 * 1
 * 0
 * Explanation:
 * TestCase 1: Comparing the first level before the first '.' we get 0<1. So v1
 * TestCase 2: Comparing on the first level we get 1=1. On the second level, we consider v2 to be zero and we get 0=0. On the third level, we again consider v2 to be zero while v1 is 1. So we get v1>v2.
 * TestCase 3: Trailing zeroes are ignored. So v1 = v2.
 */
public class CompareVersionNumber {
    public static void main(String[] args) {
        System.out.println(VersionCompare("2.01", "2.001"));
        System.out.println(VersionCompare("1.0.1", "1"));
        System.out.println(VersionCompare("0.2","1.0"));
    }

    public static int VersionCompare(String v1, String v2) {

        String v11[] = v1.split("\\.");
        String v22[] = v2.split("\\.");

        int i = 0;
        while (i < Math.max(v11.length, v22.length)) {
            int n1 = 0, n2 = 0;
            if (i < v11.length) {
                n1 = Integer.parseInt(v11[i]);
            }
            if (i < v22.length) {
                n2 = Integer.parseInt(v22[i]);
            }

            if (n1 - n2 != 0) {
                if((n1-n2)<0){
                    return -1;
                }else{
                    return 1;
                }
                // return n1 - n2;
            }
            i++;
        }

        return 0;

    }

}
