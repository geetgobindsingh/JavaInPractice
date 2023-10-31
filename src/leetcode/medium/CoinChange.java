package leetcode.medium;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        dp[0] = 0;
        for (int amt = 1; amt <= amount; amt++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if ((amt - coin) >= 0 && dp[amt - coin] != null) {
                    min = Math.min(min, dp[amt - coin]);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[amt] = 1 + min;
                }
            }
        }

        if (dp[amount] != null) {
            return dp[amount];
        }
        return -1;
    }

}
