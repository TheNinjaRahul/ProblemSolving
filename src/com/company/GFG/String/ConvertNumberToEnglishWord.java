package com.company.GFG.String;

import java.util.HashMap;
import java.util.Map;

public class ConvertNumberToEnglishWord {
    public static void main(String[] args) {
        System.out.println(convertToWords(123456789));
    }

    public static String convertToWords(int n) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");
        map.put("11", "eleven");
        map.put("12", "twelve");
        map.put("13", "thirteen");
        map.put("14", "fourteen");
        map.put("15", "fifteen");
        map.put("16", "sixteen");
        map.put("17", "seventeen");
        map.put("18", "eighteen");
        map.put("19", "nineteen");
        map.put("20", "twenty");
        map.put("30", "thirty");
        map.put("40", "forty");
        map.put("50", "fifty");
        map.put("60", "sixty");
        map.put("70", "seventy");
        map.put("80", "eighty");
        map.put("90", "ninety");
        map.put("100", "hundred");
        map.put("0", "");

        String result = "";

        if (n > 9999999) {
            result += getNumberToString(n / 10000000, map) + " crore ";
            n %= 10000000;
        }
        if (n > 99999) {
            result += getNumberToString(n / 100000, map) + " lakh ";
            n %= 100000;
        }
        if (n > 999) {
            result += getNumberToString(n / 1000, map) + " Thousand ";
            n %= 1000;
        }
        if (n > 99) {
            result += getNumberToString(n / 100, map) + " Hundred ";
            n %= 100;
        }
        result += getNumberToString(n, map);

//        System.out.println(result);


        return result;
    }

    private static String getNumberToString(int n, Map<String, String> map) {
        if (n < 20) {
            return map.get(String.valueOf(n));
        } else {
            int temp = n % 10;
            n = n / 10;
            return map.get(n + "0") + " " + map.get(String.valueOf(temp));
        }
    }

    public static String convertToWords2(int n) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        map.put("4", "four");
        map.put("5", "five");
        map.put("6", "six");
        map.put("7", "seven");
        map.put("8", "eight");
        map.put("9", "nine");
        map.put("10", "ten");
        map.put("11", "eleven");
        map.put("12", "twelve");
        map.put("13", "thirteen");
        map.put("14", "fourteen");
        map.put("15", "fifteen");
        map.put("16", "sixteen");
        map.put("17", "seventeen");
        map.put("18", "eighteen");
        map.put("19", "nineteen");
        map.put("20", "twenty");
        map.put("30", "thirty");
        map.put("40", "forty");
        map.put("50", "fifty");
        map.put("60", "sixty");
        map.put("70", "seventy");
        map.put("80", "eighty");
        map.put("90", "ninety");
        map.put("100", "hundred");
        map.put("0", "");


        String crore = "";
        String lakh = "";
        String tk = "";
        String hundred = "";
        String number = "";

        int count = 0;
        while (n > 0) {
            int no = n % 10;
            n = n / 10;

            if (count < 2) {
                number = no + number;
                count++;
                continue;
            }
            if (count < 3) {
                hundred = String.valueOf(no);
                count++;
                continue;
            }
            if (count < 5) {
                tk = no + tk;
                count++;
                continue;
            }
            if (count < 7) {
                lakh = no + lakh;
                count++;
                continue;
            }
            if (count < 9) {
                crore = no + crore;
                count++;
                continue;
            }
        }
        String result = "";
        if (crore != null) {
            if (Integer.parseInt(crore) < 20) {
                result += map.get(crore) + " crore ";
            } else {
                result += map.get(crore.charAt(0) + "0") + " " + (map.get(crore.charAt(1)) == null ? "" : map.get(crore.charAt(1) + ""));
                result += " crore ";
            }
        }

        if (lakh != null) {
            if (Integer.parseInt(lakh) < 20) {
                result += map.get(lakh) + "lakh ";
            } else {
                result += map.get(lakh.charAt(0) + "0") + " " + (map.get(lakh.charAt(1)) == null ? "" : map.get(lakh.charAt(1) + ""));
                result += "lakh ";
            }
        }
        if (tk != null) {
            if (Integer.parseInt(tk) < 20) {
                result += map.get(tk) + "thousand ";
            } else {
                result += map.get(tk.charAt(0) + "0") + " " + (map.get(tk.charAt(1)) == null ? "" : map.get(tk.charAt(1) + ""));
                result += "thousand ";
            }
        }

        if (hundred != null) {
            result += map.get(hundred) + " hundred ";
        }
        if (number != null) {
            if (Integer.parseInt(number) < 20) {
                result += map.get(number);
            } else {
                result += map.get(number.charAt(0) + "0") + " " + (map.get(number.charAt(1) + "") == null ? "" : map.get(number.charAt(1) + ""));
            }
        }

        return result;
    }
}
