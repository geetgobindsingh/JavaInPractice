package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumEarningsFromTaxi {
    public static void main(String[] args) {
        MaximumEarningsFromTaxi obj = new MaximumEarningsFromTaxi();
        System.out.println(obj.maxTaxiEarnings(5, new int[][]{{2, 5, 4}, {1, 5, 1}}));
        System.out.println(obj.maxTaxiEarnings(10, new int[][]{{9, 10, 2}, {4, 5, 6}, {6, 8, 1}, {1, 5, 5},
                {4, 9, 5}, {1, 6, 5}, {4, 8, 3}, {4, 7, 10}, {1, 9, 8}, {2, 3, 5}}));
        System.out.println(obj.maxTaxiEarnings(20, new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2}, {13, 18, 1}}));
    }

    private static class Job {
        private int start;
        private int end;
        private int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    private int binarySearch(Job jobs[], int index) {
        int low = 0;
        int high = index - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid].start >= jobs[index].end) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public long maxTaxiEarnings(int n, int[][] rides) {
        Job jobs[] = new Job[rides.length];
        for (int i = 0; i < rides.length; i++) {
            jobs[i] = new Job(rides[i][0], rides[i][1], rides[i][1] - rides[i][0] + rides[i][2]);
        }
        Arrays.sort(jobs, (j1, j2) -> (j1.start - j2.start));
        long[] dp = new long[rides.length];
        dp[0] = jobs[0].profit;
        for (int i = 1; i < jobs.length; i++) {
            long include = jobs[i].profit;
            int index = binarySearch(jobs, i);
            if (index != -1) {
                include += dp[index];
            }
            dp[i] = Math.max(include, dp[i - 1]);
        }
        return dp[rides.length - 1];
    }
}
