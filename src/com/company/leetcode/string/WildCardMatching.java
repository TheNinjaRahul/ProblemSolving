package com.company.leetcode.string;

public class WildCardMatching {
    public static void main(String[] args) {



        System.out.println("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab" + "***bba**a*bbba**aab**b" + isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")); // time limit issue in LC
        System.out.println("mississippi" + "m??*ss*?i*pi: true:" + isMatch("mississippi", "m??*ss*?i*pi"));
        System.out.println("ho" + "ho**: true:" + isMatch("ho", "ho**"));
        System.out.println("" + "*: true:" + isMatch("", "*"));
        System.out.println("aa" + ",a: false:" + isMatch("aa", "a"));
        System.out.println("aa" + ",*: true:" + isMatch("aa", "*"));
        System.out.println("cb" + ",?a: false:" + isMatch("cb", "?a"));
        System.out.println("adceb" + ",*a*b: true:" + isMatch("adceb", "*a*b"));
        System.out.println("acdcb" + ",a*c?b: false:" + isMatch("acdcb", "a*c?b"));
        System.out.println("baaabab" + ",*****ba*****ab: true:" + isMatch("baaabab", "*****ba*****ab"));
        System.out.println("baaabab" + ",baaa?ab: true:" + isMatch("baaabab", "baaa?ab"));
        System.out.println("baaabab" + ",ba*a?: true:" + isMatch("baaabab", "ba*a?"));
        System.out.println("baaabab" + ",a*ab: false:" + isMatch("baaabab", "a*ab"));
    }


    public static boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if(s.length() == 0 && p.charAt(0)=='*'){
            return isMatch(s,p.substring(1));
        }


        if (s.length()!=0 && s.charAt(0) == p.charAt(0)) {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            if (s.length()!=0 &&p.charAt(0) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            } else {
                if (s.length()!=0 && p.charAt(0) == '*') {
                    return isMatch(s.substring(1), p.substring(1)) || isMatch(s.substring(1), p) || isMatch(s, p.substring(1));
                }
            }

        }

        return false;

    }
}



