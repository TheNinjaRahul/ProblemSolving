package com.company.GFG.String;

        import java.util.ArrayList;
        import java.util.List;

/***
 * Generate IP Addresses
 * Given a string S containing only digits, Your task is to complete the function genIp() which returns a vector containing all possible combination of valid IPv4 ip address and takes only a string S as its only argument.
 * Note : Order doesn't matter.
 *
 * For string 11211 the ip address possible are
 * 1.1.2.11
 * 1.1.21.1
 * 1.12.1.1
 * 11.2.1.1
 *
 * 25525511135
 * 25505011535
 * Input:
 * The first line of input will contain no of test cases T. Then T test cases follow . Each test case will contains a string S.
 *
 * Output:
 * For each test case, print the ip addresses in sorted order. You don't need to print it, printing is done by driver code.
 *
 *
 * Your Task:
 * Your task is just to complete the function genIp().
 *
 *
 * Constraints:
 * 1<=T<=100
 * 1<=|S|<=16
 * S only contains digits(i.e. 0-9)
 *
 * Example(To be used only for expected output):
 * Input
 * 1
 * 1111
 *
 * Output
 *
 * 1.1.1.1
 */
public class GenerateIPAddresses {
    public static void main(String[] args) {
        String s="11211";
//        System.out.println(s.substring(2));
        System.out.println(genIp("50361"));
//        System.out.println(genIp("25525511135"));
//        System.out.println(genIp("25505011535"));

    }

    public static List<String> genIp(String s) {

        List<String> list=new ArrayList<>();
        String[] result=new String[4];
        for(int i=1;i<s.length();i++){
            String no=s.substring(0,i);
            if(Integer.parseInt(no)>256 ){
                break;
            }

            if(Integer.parseInt(no)<256){
                result[0]=s.substring(0,i);
                List<String> mini=getAllIps(s.substring(i),result,1);
                list.addAll(mini);
            }
        }
        return list;
    }

    private static List<String> getAllIps(String s, String[] result, int l) {


        List<String> list=new ArrayList<>();

        if(l==result.length && s.length()==0){
            for(int i=0;i<4;i++){
                if(!isValidIpNumber(result[i])){
                    return list;
                }
            }
            list.add(result[0]+"."+result[1]+"."+result[2]+"."+result[3]);
            return list;
        }
        if(l==4) return list;

        for(int i=0;i<s.length();i++){
            String no=s.substring(0,i+1);
            if(Integer.parseInt(no)>256 ){
                break;
            }
            if(Integer.parseInt(no)<256){
                result[l]=s.substring(0,i+1);
                List<String> mini=getAllIps(s.substring(i+1),result,l+1);
                result[l]="";
                list.addAll(mini);
            }
        }
        return list;
    }

    private static boolean isValidIpNumber(String s) {
        if(s.length()>1 && s.charAt(0)=='0'){
            return false;
        }
        return true;
    }
}
