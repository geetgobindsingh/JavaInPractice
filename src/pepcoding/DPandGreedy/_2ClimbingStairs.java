package pepcoding.DPandGreedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2ClimbingStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(stairsRecursive(n));
        System.out.println(stairsDP(n, new int[n + 1]));
        System.out.println(stairsTabulation(n, new int[n + 1]));
    }

    private static int stairsRecursive(int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }
        return stairsRecursive(n - 1) + stairsRecursive(n - 2) + stairsRecursive(n - 3);
    }

    private static int stairsDP(int n, int[] dp) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        } else if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = stairsDP(n - 1, dp) + stairsDP(n - 2, dp) + stairsDP(n - 3, dp);
        return dp[n];
    }

    private static int stairsTabulation(int n, int[] dp) {
        // 1.) Storage and add meaning to it
        // 2.) Direction of problem (choose which is smaller problem to solve then go to larger)
        // 3.) Traverse
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        return dp[n];
    }

}
