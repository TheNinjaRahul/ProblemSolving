package com.company.leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(getCommonPrefix(strs));

    }

    private static String getCommonPrefix(String[] strs) {
        String result=strs[0];

        for(int i=1;i<strs.length;i++){
            int j=0;
            while (true){
                if(result.length()>j && strs[i].length()>j){
                    char r=result.charAt(j);
                    char s=strs[i].charAt(j);
                    if(r==s){
                        j++;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
            result=result.substring(0,j);
        }
        return result;
    }
}
