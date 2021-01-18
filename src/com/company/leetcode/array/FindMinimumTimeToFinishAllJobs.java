package com.company.leetcode.array;

import java.util.Arrays;

public class FindMinimumTimeToFinishAllJobs {

    int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        FindMinimumTimeToFinishAllJobs findMinimumTimeToFinishAllJobs = new FindMinimumTimeToFinishAllJobs();
        findMinimumTimeToFinishAllJobs.minimumTimeRequired(new int[]{1, 2, 3}, 2);

    }

    public int minimumTimeRequired(int[] jobs, int k) {
        int[] ka = new int[k];
//        findAns(jobs,ka);
        perm(jobs, 0, ka);
        return ans;
    }

    private void perm(int[] jobs, int i, int[] ka) {
        if (i == jobs.length - 1) {
            findAns(jobs, ka);
        }
        for (int j = i; j < jobs.length; j++) {
            swap(jobs, i, j);
            perm(jobs, i + 1, ka);
            swap(jobs, i, j);
        }
    }

    private void swap(int[] jobs, int i, int j) {
        int temp = jobs[i];
        jobs[i] = jobs[j];
        jobs[j] = temp;
    }

    private void findAns(int[] jobs, int[] ka) {
        Arrays.fill(ka, 0);
        for (int i = 0; i < jobs.length; i++) {
            ka[i % ka.length] += jobs[i];
        }
        System.out.println(Arrays.toString(jobs));

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < ka.length; i++) {
            max = Math.max(max, ka[i]);
        }
        ans = Math.min(max, ans);
    }
}
