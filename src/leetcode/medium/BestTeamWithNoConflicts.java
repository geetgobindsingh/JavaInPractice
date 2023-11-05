package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class BestTeamWithNoConflicts {
    public static void main(String[] args) {
        BestTeamWithNoConflicts obj = new BestTeamWithNoConflicts();
        System.out.println(obj.bestTeamScore(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(obj.bestTeamScore(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, new int[]{811, 364, 124, 873, 790, 656, 581, 446, 885, 134}));
        System.out.println(obj.bestTeamScore(new int[]{1, 3, 7, 3, 2, 4, 10, 7, 5}, new int[]{4, 5, 2, 1, 1, 2, 4, 1, 4}));
    }

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] ar = new int[n][2];
        for (int i = 0; i < n; i++) {
            ar[i] = new int[]{scores[i], ages[i]};
        }
        Arrays.sort(ar, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[n];
        dp[0] = ar[0][0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            int maxSum = 0;
            for (int j = 0; j < i; j++) {
                if (!(ar[j][0] > ar[i][0] && ar[j][1] <= ar[i][1])) {
                    maxSum = Math.max(maxSum, dp[j]);
                }
            }
            dp[i] = ar[i][0] + maxSum;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
