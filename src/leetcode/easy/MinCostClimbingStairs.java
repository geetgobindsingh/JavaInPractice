package leetcode.easy;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        MinCostClimbingStairs obj = new MinCostClimbingStairs();
        System.out.println(obj.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(obj.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) { // dp // Bottom up computation - O(n) time, O(1) space
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        if (n <= 2) return Math.min(first, second);
        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }
        return Math.min(first, second);
    }

    public int minCostClimbingStair2(int[] cost) { // dp
        if (cost.length <= 1) {
            return 0;
        }
        int[] dp = new int[cost.length + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            if (i == cost.length) {
                dp[i] = Math.min((dp[i - 1]), (dp[i - 2]));
            } else {
                dp[i] = Math.min((cost[i] + dp[i - 1]), (cost[i] + dp[i - 2]));
            }
        }
        return dp[cost.length];
    }

    public int minCostClimbingStairs1(int[] cost) { // resursive
        if (cost.length <= 1) {
            return 0;
        }
        return Math.min(getMinCost(0, cost, 0), getMinCost(1, cost, 0));
    }

    private int getMinCost(int i, int[] cost, int csf) {
        if (i >= cost.length) {
            return csf;
        }
        int step1 = getMinCost(i + 1, cost, csf + cost[i]);
        int step2 = getMinCost(i + 2, cost, csf + cost[i]);
        return Math.min(step1, step2);
    }
}
