package com.company.leetcode.string;

import java.util.Arrays;

public class CheckIfStringIsValidIpv4Ipv6ORNeither {
    public static void main(String[] args) {
        String s1="172.16.254.1";
        String s2="2001:0db8:85a3:0000:0000:8A2E:0370:7334";
        String s3="1e1.4.5.6";
        String s4="192.0.0.1";
        String s5="-0.0.0.-0";
        System.out.println(Arrays.toString("1:1:1:x:".split(":")));
//        System.out.println(validIPAddress(s1));
//        System.out.println(validIPAddress(s2));
//        System.out.println(validIPAddress(s3));
//        System.out.println(validIPAddress(s4));
        System.out.println(validIPAddress(s5));
    }

    public static String validIPAddress(String IP) {

        String result="";
        if(IP.contains(".")){
            result=checkIpv4(IP);
        }else{
            result=checkIpv6(IP);
        }
        return result=="" ? "Neither" : result;
    }

    private static String checkIpv6(String ip) {
        String result="";

        if(ip.length()<15) return result;
        if(ip.charAt(0)==':') return result;
        if(ip.charAt(ip.length()-1)==':') return result;

        if(ip.charAt(ip.length()-1)==':'){
            return result;
        }
        String[] digits=ip.split(":");
        if(digits.length!=8){
            return "";
        }
        for(String s:digits){
            if(!isValidIpv6Block(s)){
                return result;
            }
        }
        return "IPv6";
    }

    private static boolean isValidIpv6Block(String s) {
        if(s.length()==0 || s.length()>4){
            return false;
        }
        s=s.toUpperCase();
        for(int i=0;i<s.length();i++){
            if (Character.digit(s.charAt(i), 16)==-1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidIpv4Block(String s) {

        if(s.length()==0) return false;
        try{
            if((s.charAt(0)=='0' && s.length()>1) || s.charAt(0)=='-'){
                return false;
            } else if(Integer.parseInt(s)>=0 && Integer.parseInt(s)<256){
                return true;
            } else{
                return false;
            }
        }catch (Exception e){
            return false;
        }

    }

    private static String checkIpv4(String ip) {
        String result="";
        if(ip.length()<7) return result;
        if(ip.charAt(0)=='.') return result;
        if(ip.charAt(ip.length()-1)=='.') return result;

        if(ip.charAt(ip.length()-1)=='.'){
            return result;
        }
        String[] digits=ip.split("\\.",-1);
        if(digits.length!=4){
            return "";
        }
        for(String s:digits){
            if(!isValidIpv4Block(s)){
                return result;
            }
        }
        return "IPv4";
    }
}
