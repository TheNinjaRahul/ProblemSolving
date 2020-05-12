package com.company.leetcode.dp;

public class WildCardMatching {
    public static void main(String[] args) {


//        System.out.println("ho" + " ho**: true:" + isMatch("ho", "ho**"));
        System.out.println("" + "*: true:" + isMatch("", "*") + " " +isMatch2("", "*"));
//        System.out.println(isMatch2("a", ""));
        System.out.println("a" + ": false:" + isMatch("a", "") + " " +isMatch2("a", ""));
        System.out.println("aa" + ",a: false:" + isMatch("aa", "a") + " "+isMatch2("aa", "a"));
        System.out.println("aa" + ",*: true:" + isMatch("aa", "*")+ " "+ " "+isMatch2("aa", "*"));
        System.out.println("cb" + ",?a: false:" + isMatch("cb", "?a") +" "+isMatch2("cb", "?a"));
        System.out.println("adceb" + ",*a*b: true:" + isMatch("adceb", "*a*b")+" "+isMatch2("adceb", "*a*b"));
        System.out.println("acdcb" + ",a*c?b: false:" + isMatch("acdcb", "a*c?b")+" "+isMatch2("acdcb", "a*c?b"));
        System.out.println("baaabab" + ",*****ba*****ab: true:" + isMatch("baaabab", "*****ba*****ab")+" "+isMatch2("baaabab", "*****ba*****ab"));
        System.out.println("baaabab" + ",baaa?ab: true:" + isMatch("baaabab", "baaa?ab")+" "+isMatch2("baaabab", "baaa?ab"));
        System.out.println("baaabab" + ",ba*a?: true:" + isMatch("baaabab", "ba*a?")+" "+isMatch2("baaabab", "ba*a?"));
        System.out.println("baaabab" + ",a*ab: false:" + isMatch("baaabab", "a*ab")+" "+isMatch2("baaabab", "a*ab"));
        System.out.println("mississippi" + "m??*ss*?i*pi: true:" + isMatch("mississippi", "m??*ss*?i*pi")+" "+isMatch2("mississippi", "m??*ss*?i*pi"));
        System.out.println("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab" + "***bba**a*bbba**aab**b" + isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")+" "+isMatch2("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")); // time limit issue in LC
    }


    public static boolean isMatch(String str, String pt) {

        char[] s=str.toCharArray();
        char[] p=pt.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int wi=0;
        boolean isfirst=true;
        String patter="";
        for(int i=0;i<p.length;i++){

            if(p[i]=='*'){
                if(isfirst){
                    p[wi++]=p[i];
                    isfirst=false;
                }
            }else{
                p[wi++]=p[i];
                isfirst=true;
            }
        }


        boolean [][]table= new boolean[s.length+1][wi+1];
        if (p.length > 0 && p[0] == '*') {
            table[0][1] = true;
        }
        table[0][0]=true;

//        printTable(table,s,p);
        for(int i=1;i<table.length;i++){
            char schar = s[i - 1];
            for(int j=1;j<table[0].length;j++){
                char pchar = p[j - 1];
                if( p[j-1]=='?' || p[j-1]==s[i-1]){
                    table[i][j]=table[i-1][j-1];
                }else if(p[j-1]=='*'){
                    table[i][j]=table[i][j-1] || table[i-1][j];
                }else{
                    table[i][j]=false;
                }
            }
        }
//        printTable(table,s,p);
        return table[s.length][wi];
    }

    private static void printTable(boolean[][] table, String s, String p) {
        System.out.println("   ");
        System.out.print("   ");
        for (int i = 0; i < table[0].length; i++) {
            if (i != 0) {
                System.out.print("  " + p.charAt(i - 1));
            } else System.out.print("  ");
        }
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            if (i != 0) {
                System.out.print(" " + s.charAt(i - 1));
            } else System.out.print("  ");

//            System.out.print(" "+s.charAt(i-1));
            for (int j = 0; j < table[0].length; j++) {
                char ch = table[i][j] ? 'T' : 'F';
                System.out.print(" " + " " + ch);
            }
            System.out.println();
        }
    }


    public static boolean isMatch2(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        //replace multiple * with one *
        //e.g a**b***c --> a*b*c
        int writeIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[writeIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[writeIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][writeIndex + 1];

        if (writeIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][writeIndex];
    }
}



