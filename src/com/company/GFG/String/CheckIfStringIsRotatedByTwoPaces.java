package com.company.GFG.String;

/***
 * Given two strings a and b. The task is to find if the string 'b' can be obtained by rotating another string 'a' by exactly 2 places.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. In the next two lines are two string a and b respectively.
 *
 * Output:
 * For each test case in a new line print 1 if the string 'a' can be obtained by rotating string 'b' by two places else print 0.
 *
 * User Task:
 * The task is to complete the function isRotated() which checks if given strings can be formed by rotations. The function returns true if string 1 can be obtained by rotating string 2 by two places, else it returns false.
 *
 * Expected Time Complexity: O(N).
 * Expected Space Complexity: O(N).
 * Challenge: Try doing it in O(1) space complexity.
 *
 * Constraints:
 * 1 <= T <= 50
 * 1 <= length of a, b < 100
 *
 * Example:
 * Input:
 * 2
 * amazon
 *
 * geeksforgeeks
 * geeksgeeksfor
 * Output:
 * 1
 * 0
 *
 * Explanation:
 * Testcase 1: amazon can be rotated anti-clockwise by two places, which will make it as azonam.
 * Testcase 2: If we rotate geeksforgeeks by two place in any direction , we won't get geeksgeeksfor.
 */
public class CheckIfStringIsRotatedByTwoPaces {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "azonam";
//        System.out.println(isRotated(s1,s2));
        String s3 = "geeksforgeeks";
        String s4 = "geeksgeeksfor";
//        System.out.println(isRotated(s3,s4));
        String s5 = "fsbcnuvqhffbsaqxwp";
        String s6 = "wpfsbcnuvqhffbsaqx";
        System.out.println(isRotated(s5, s6));
    }

    public static boolean isRotated(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        boolean result = false;
        int index = s2.length() - 2;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(index % s2.length())) {
                result = true;
                break;
            }
            index++;
        }

        if (!result) {
            return true;
        }
        index = 2;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(index % s2.length())) {
                return false;
            }
            index++;
        }
        return true;
    }
}
