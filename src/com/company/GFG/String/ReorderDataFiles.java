package com.company.GFG.String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Reorder data files
 * You have an array of files names. Each file is a space delimited string of words.
 * <p>
 * The first word in each file is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of files letter-files and digit-files.  It is guaranteed that each file has at least one word after its identifier.
 * <p>
 * Reorder the files so that all of the letter-files come before any digit-files.  The letter-files are ordered lexicographically without considering identifier, with the identifier used in case of ties.  The digit-files should be put in their original order of occurance.
 * <p>
 * Input:
 * The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. Each test case consist of N+1 lines. The first line of each test case consists of an integer N, where N is the number of files.The other N lines contains the names of files.
 * <p>
 * Your Task:
 * Complete fileReorder() function and return the vector of the string containing the files name in the required order.
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ N ≤ 1000
 * 3 <= files.length <= 100
 * <p>
 * Example:
 * Input:
 * 2
 * 3
 * file1 1 2 3
 * space2 geeksforgeeks
 * true1 check
 * 2
 * file2 hi
 * file3 hi
 * Output:
 * true1 check
 * space2 geeksforgeeks
 * file1 1 2 3
 * file2 hi
 * file3 hi
 * Explanation:
 * Testcase 1: Since first we need to print the letter-files there are two letter-files present "true1 check"
 * "space2 geeksforgeeks", according to problem they should be sorted after ignoring their identifier so "true1 check" should comes before "space2 geeksforgeeks" as (check < geeksforgeeks). Then we are left with only one digit file i.e "file1 1 2 3" so we will put it at last.
 */
public class ReorderDataFiles {
    public static void main(String[] args) {
        String[] data = {"file1 1 2 3",
                "space2 geeksforgeeks",
                "true1 check"};

        System.out.println(Arrays.toString(fileReorder(data)));

    }


    public static String[] fileReorder(String[] files) {

        Comparator<String> comparable = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int index1 = o1.indexOf(" ") + 1;
                int index2 = o2.indexOf(" ") + 1;
                if (Character.isLetter(o1.charAt(index1)) && Character.isLetter(o2.charAt(index2))) {
                    int cmp = o1.substring(index1).compareTo(o2.substring(index2));
                    return cmp == 0 ? o1.compareTo(o2) : cmp;
                } else if (Character.isLetter(o1.charAt(index1))) {
                    return -1;
                } else if (Character.isLetter(o2.charAt(index2))) {
                    return 1;
                } else {
                    return 0;
                }

            }
        };

        Arrays.sort(files, comparable);
        return files;

    }
}
