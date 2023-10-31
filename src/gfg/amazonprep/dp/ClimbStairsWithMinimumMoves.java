package gfg.amazonprep.dp;

import java.io.IOException;

public class ClimbStairsWithMinimumMoves {
    public static void main(String[] args) throws IOException {
        System.out.println(numberOfDiffPaths(10, new int[]{3, 3, 0, 2, 1, 2, 4, 2, 0, 0}));
    }

    private static int numberOfDiffPaths(int n, int[] stairs) {
        int dp[] = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= stairs[i] && ((i + j) <= n); j++) {
                if (dp[i + j] != 0) {
                    min = Math.min(min, dp[i + j]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = dp[i] + min + 1;
            }
        }
        return dp[0] - 1;
    }

}
