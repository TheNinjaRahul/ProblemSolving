package com.company.GFG.String;

public class ValidateIpAddress {
    public static void main(String[] args) {
        System.out.println(isValidIP("0.0.0.0."));
    }
    public static boolean isValidIP(String s) {

        String str[]=s.split("\\.");
        if (str.length > 4 | str.length==0 || str.length < 4) {
            return false;
        }
        for(String i:str){
            {
                try{
                    if(i.length()==0 || (i.charAt(0)=='0' && i.length()!=1) || i.charAt(0)=='-' || Integer.parseInt(i)>255){
                        return false;
                    }
                }catch (Exception e){
                    return false;
                }

            }
        }
        if(s.charAt(s.length()-1)!='.'){
            return true;
        }else{
            return false;
        }


    }
}
