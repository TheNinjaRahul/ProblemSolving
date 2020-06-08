package com.company.GFG.String;

/***
 * Implement strstr
 * Your task is to implement the function strstr.
 * The function takes two strings as arguments (s,x)
 * and  locates the occurrence of the string x in the string s.
 * The function returns and integer denoting the first occurrence of the string x in s.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases .
 * Then T test cases follow. The first line of each test case contains two strings s and x.
 *
 * Output:
 * For each test case, in a new line, output will be an integer denoting the first occurrence of the x in the string s. Return -1 if no match found.
 *
 * Your Task:
 * Since this is a function problem, you don't have to take any input. Just complete the strstr() function. The function returns -1 if no match if found else it returns an integer denoting the first occurrence of the x in the string s.
 *
 * Note : Try to solve the question in constant space complexity.
 *
 * Constraints:
 * 1 <= T <= 200
 * 1 <= |s|,|x| <= 1000
 *
 * Example:
 * Input
 * 2
 * GeeksForGeeks Fr
 * GeeksForGeeks For
 * Output
 * -1
 * 5
 *
 * Explanation:
 * Testcase 1: Fr is not present in the string GeeksForGeeks as substring.
 * Testcase 2: For is present as substring in GeeksForGeeks from index 5.
 */
public class Strstr {
    public static void main(String[] args) {
//        String str="GeeksForGeeks";
//        String target="fr";
        String str="abxabcabcaby";
        String target="abcaby";
        System.out.println(strstr(str,target));
    }

    static int strstr(String str, String target)
    {
        int result=-1;
        int [] kmp=createKmpTargetTable(target);
        int i=0,j=0;
        while(i<str.length()){
            if(j==target.length()){
                return i-j;
            }
            if(str.charAt(i)==target.charAt(j)){
                j++;
                i++;
            }else{
                if(j!=0){
                    j=kmp[j-1];
                }else{
                    j=0;
                    i++;
                }
            }
        }

        if(j==target.length()){
            return i-j;
        }
        return -1;
    }

    private static int[] createKmpTargetTable(String target) {
        int i=0,j=1;
        int[] table=new int[target.length()];
        for(;j<target.length();j++){
                if(target.charAt(i)==target.charAt(j)){
                    table[j]=i+1;
                    i++;
//                    j++;
                }else {
                    if(i==0){
                        table[j]=i;
                    }else{
                        table[j]=table[i-1];
                    }
                }
        }
        return table;
    }
}
