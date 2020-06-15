package com.company.GFG.String;

/**
 * Excel Sheet | Part - 2
 * Given a string S that represents column title of an Excel sheet, find the number that represents that column.
 * In excel A column is number 1, AA is 27 and so on.
 *
 * Input:
 * The first line contains an integer T, depicting total number of test cases. T testcases follow. Each testcase contains a single line of input containing string S.
 *
 * Output:
 * For each testcase, in a new line, print the column number.
 *
 * User Task:
 * Complete the function ExcelColumnNumber() which taked a string as input and returns an integer.
 *
 * Constraints:
 * 1 ≤ T ≤ 100
 * 1 ≤ |S| <=7
 *
 * Example:
 * Input
 * 2
 * A
 * AA
 * Output
 * 1
 * 27
 */
public class ExcelSheetFindStringToNumber {
    public static void main(String[] args) {
        System.out.println(excelColumnNumber("UMU"));
    }

    public static int excelColumnNumber(String s) {
        int num=0;//(s.charAt(s.length()-1)-'A'+1);
        int j=s.length()-1;
        for(int i=0;i<s.length();i++){
            num+=Math.pow(26,(j--))*(s.charAt(i)-'A'+1);
        }
        return num;
    }
}
