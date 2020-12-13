package com.company.codility;

public class ReverseNumber {
    public static void main(String[] args) {
        ReverseNumber r = new ReverseNumber();
        r.solution(100002);
        System.out.println();
        r.solution(10000);
        System.out.println();

        System.out.println();
        r.solution(1020);
        System.out.println();
        r.solution(54321);
    }

    public void solution(int N) {
        int enable_print = N % 10;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print >= 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }
}
