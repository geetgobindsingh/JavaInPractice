package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _UnboundedKnapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] val = new int[n];
        String[] vals = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(vals[i]);
        }
        int[] wt = new int[n];
        String[] wts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            wt[i] = Integer.parseInt(wts[i]);
        }
        int tar = Integer.parseInt(br.readLine());
        System.out.print(maxValue(n, wt, val, tar));
    }

    // Faster
    private static int maxValue(int n, int[] wt, int[] val, int tar) {
        int[] dp = new int[tar + 1];
        for (int bagCapacity = 1; bagCapacity <= tar; bagCapacity++) {
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (bagCapacity >= wt[i - 1]) {
                    max = Math.max(max, val[i - 1] + dp[bagCapacity - wt[i - 1]]);
                }
            }
            dp[bagCapacity] = max;
        }
        return dp[tar];
    }

    // Slower
    private static int maxValue1(int n, int[] wt, int[] val, int tar) {
        int[][] dp = new int[n + 1][tar + 1];
        for (int i = 1; i <= n; i++) {
            for (int bagCapacity = 1; bagCapacity <= tar; bagCapacity++) {
                if (bagCapacity >= wt[i - 1]) {
                    dp[i][bagCapacity] = Math.max(dp[i - 1][bagCapacity], ((bagCapacity / wt[i - 1]) * val[i - 1]) + dp[i - 1][bagCapacity - (wt[i - 1] * (bagCapacity / wt[i - 1]))]);
                } else {
                    dp[i][bagCapacity] = dp[i - 1][bagCapacity];
                }
            }
        }
        return dp[n][tar];
    }
}
