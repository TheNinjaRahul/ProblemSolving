package com.company.leetcode.number;

public class ConvertIntToBinaryToNumber {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(3));
        System.out.println(concatenatedBinary(12));
        System.out.println(concatenatedBinary(50000));
    }

    public static int concatenatedBinary(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            sb.append(Integer.toBinaryString(i));
        }
        int m = (int) Math.pow(10, 9) + 7;
        int ans = getMod(sb.toString(), sb.length(), m);
        return ans;

//                BigInteger bi = new BigInteger(sb.toString(), 2);
//
//        BigInteger module = new BigInteger(String.valueOf(m));
//        String ans = bi.mod(module).toString();
//        return Integer.parseInt(ans);
    }

    public static int getMod(String str, int n, int k) {

        // pwrTwo[i] will store ((2^i) % k)
        int pwrTwo[] = new int[n];
        pwrTwo[0] = 1 % k;
        for (int i = 1; i < n; i++) {
            pwrTwo[i] = pwrTwo[i - 1] * (2 % k);
            pwrTwo[i] %= k;
        }

        // To store the result
        int res = 0;
        int i = 0, j = n - 1;
        while (i < n) {

            // If current bit is 1
            if (str.charAt(j) == '1') {

                // Add the current power of 2
                res += (pwrTwo[i]);
                res %= k;
            }
            i++;
            j--;
        }

        return res;
    }
}
