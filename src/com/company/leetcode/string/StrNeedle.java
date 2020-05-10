package com.company.leetcode.string;

public class StrNeedle {
    public static void main(String[] args) {
//        "mississippi"
//        "issip"
        System.out.println(strStr("mississippi","issip"));
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        int j=0;
        for(int i=0;i<haystack.length();i++){
            j=0;
            if(haystack.charAt(i)==needle.charAt(j)){
                int k=i+1;
                j++;
                while(true){
                    if(j < needle.length() && k < haystack.length() && haystack.charAt(k)==needle.charAt(j)){
                        k++;
                        j++;
                    }else{
                        break;
                    }
                }
                if(j==needle.length()){
                    return i;
                }else {
                    i=k-2;
                }
            }
        }
        return -1;
    }
}
