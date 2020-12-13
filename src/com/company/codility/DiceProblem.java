package com.company.codility;

public class DiceProblem {

    public static void main(String[] args) {
        DiceProblem d = new DiceProblem();

        System.out.println(d.solution(new int[]{1}));
        System.out.println(d.solution(new int[]{1, 2, 3}));
        System.out.println(d.solution(new int[]{1, 1, 6}));
        System.out.println(d.solution(new int[]{1, 6, 2, 3}));
    }

    public int solution(int[] A) {
        int count;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            count = 0;
            for (int j = 0; j < A.length; j++) {
                if (i == A[j]) {
                    count += 0;
                } else if (i + A[j] == 7) {
                    count += 2;
                } else {
                    count += 1;
                }
            }
            ans = Math.min(ans, count);
        }
        return ans;
    }
}
