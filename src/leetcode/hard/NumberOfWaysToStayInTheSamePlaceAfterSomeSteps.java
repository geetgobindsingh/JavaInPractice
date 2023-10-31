package leetcode.hard;

import java.util.Arrays;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args) {
        NumberOfWaysToStayInTheSamePlaceAfterSomeSteps obj = new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps();
        System.out.println(obj.numWays(3, 2));
        System.out.println(obj.numWays(2, 4));
        System.out.println(obj.numWays(4, 2));
        System.out.println(obj.numWays(27, 7));
        System.out.println(obj.numWays(47, 38));
        System.out.println(obj.numWays(430, 148488));
    }

    public int numWays(int steps, int arrLen) {
        int mod = 1000_000_007;
        int[][] dp = new int[steps][steps];
        for (int[] l : dp) {
            Arrays.fill(l, -1);
        }
        int val = traverse(0, steps, arrLen, dp, mod);
        return (val % mod);
    }

    private int traverse(int i, int steps, int arrLen, int[][] dp, int mod) {
        if (i < 0 || i >= arrLen) {
            return 0;
        }
        if (steps == 0) {
            return i == 0 ? 1 : 0;
        }
        if (dp[i][steps - 1] != -1) {
            return dp[i][steps - 1] % mod;
        }
        int left = traverse(i - 1, steps - 1, arrLen, dp, mod) % mod;
        int stay = traverse(i, steps - 1, arrLen, dp, mod) % mod;
        int right = traverse(i + 1, steps - 1, arrLen, dp, mod) % mod;
        dp[i][steps - 1] = ((left + stay) % mod + right) % mod;
        return dp[i][steps - 1];
    }

}
