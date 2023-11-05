package leetcode.hard;

import java.util.Arrays;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        MaximumProfitInJobScheduling obj = new MaximumProfitInJobScheduling();
//        System.out.println(obj.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
//        System.out.println(obj.jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        System.out.println(obj.jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));

    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return traverse(0, jobs, dp);
    }

    private int traverse(int i, int[][] jobs, int[] dp) {
        if (i >= jobs.length) return 0;
        if (dp[i] != -1) {
            return dp[i];
        }
        int include = jobs[i][2];
        int next = getNextPossible(jobs, jobs[i][1]);
        if (next != -1) {
            include = include + traverse(next, jobs, dp);
        }
        int exclude = traverse(i + 1, jobs, dp);
        return dp[i] = Math.max(include, exclude);
    }

    private int getNextPossible(int[][] jobs, int end) {
        int left = 0;
        int right = jobs.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int start = jobs[mid][0];
            if (start == end) {
                return mid;
            } else if (start < end) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; ++i) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int j = search(jobs, jobs[i][0], i);
            dp[i + 1] = Math.max(dp[i], dp[j] + jobs[i][2]);
        }
        return dp[n];
    }

    private int search(int[][] jobs, int x, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (jobs[mid][1] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int search(int[] jobs, int x, int n) {
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (jobs[mid] > x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
