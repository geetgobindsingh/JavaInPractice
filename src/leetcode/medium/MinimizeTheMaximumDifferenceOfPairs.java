package leetcode.medium;

public class MinimizeTheMaximumDifferenceOfPairs {
    public static void main(String[] args) {
        System.out.println(minimizeMax(new int[]{10, 1, 2, 7, 1, 3}, 3));
        //System.out.println(minimizeMax(new int[]{3,4,2,3,2,1,2}, 3));
    }

    public static int minimizeMax(int[] nums, int p) { // wrong solution tried DP
        int dp[][] = new int[nums.length][p + 1];
        for (int j = 1; j <= p; j++) {
            for (int i = (2 * j) - 1; i < nums.length; i++) {
                int inc = Integer.MAX_VALUE;
                for (int k = i - 1; k >= 0; k--) {
                    int dif = Math.abs(nums[i] - nums[k]);
                    if (dif < inc) {
                        inc = dif;
                    }
                }
                inc = Math.max(inc, dp[i - 1][j - 1]);
                int exc = Integer.MAX_VALUE;
                if (i > (2 * j) - 1) {
                    exc = dp[i - 1][j];
                }
                dp[i][j] = Math.min(inc, exc);
            }
        }
        System.out.print("\n");
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= p; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
        return dp[nums.length - 1][p];
    }
}
