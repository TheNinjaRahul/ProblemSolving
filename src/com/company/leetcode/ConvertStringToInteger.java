package com.company.leetcode;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        String s="-2";
        System.out.println(convertToNumber(s));
    }

    private static int convertToNumber(String s) {
        s=s.trim();
        int lastIndex=-1;
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i);
            if(c==45 ||c==43 ||(c>=48 && c<=57)){
                System.out.println(s.charAt(i) + " is number");
            }else{
                System.out.println(s.charAt(i) + " is not number");
                lastIndex=i;
                break;
            }
        }

        int result=0;

        try{
            if(lastIndex==-1){
                result= Integer.parseInt(s);
            }else{
                result= Integer.parseInt(s.substring(0,lastIndex));
            }
        }catch (Exception e){
            result=0;
        }
        return result;

    }
}
