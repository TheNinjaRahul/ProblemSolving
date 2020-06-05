package com.company.GFG.Hashing;

import java.util.*;

public class MatchSpecificPattern {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("abb");list.add("abc");list.add("xyz");list.add("xyy");

        System.out.println(findMatchedWords(list,"foo"));
    }

    public static ArrayList<String> findMatchedWords(ArrayList<String> dict, String pattern)
    {
        ArrayList<String> list=new ArrayList<>();
        for(String s:dict){

            if(isHaveSamePattern(s,pattern)){
                list.add(s);
            }

        }
        return list;

    }

    private static boolean isHaveSamePattern(String s, String pattern) {

        //this will not work found from GFG
        if(s.length()!=pattern.length()){
            return false;
        }
        char c[]=new char[128];
        for(int i=0;i<s.length();i++){
            int ci=s.charAt(i);
            if(c[ci]==0){
                c[ci]=pattern.charAt(i);
            }else{
                if(c[ci]!=pattern.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }


    public static ArrayList<String> findMatchedWords2(ArrayList<String> dict, String pattern)
    {

        ArrayList<String> list=new ArrayList<>();
        String inputPatter=findHash(pattern);
        for(String s:dict){
            String hash=findHash(s);
            if(hash.equals(inputPatter)){
                list.add(s);
            }
        }
        return list;
    }

    private static String findHash(String s) {
        int count=0;String result="";
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                result+=map.get(s.charAt(i));
            }else {
                count++;
                result+=count;
                map.put(s.charAt(i),count);
            }
        }

        return result;
    }
}
