package leetcode.medium;

public class CombinationSum4 {
    public static void main(String[] args) {
        CombinationSum4 obj = new CombinationSum4();
        System.out.print(obj.combinationSum4(new int[]{1,2,3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int t = 1; t <= target; t++) {
            int count = 0;
            for (int n : nums) {
                if ((t - n) >= 0) {
                    count += dp[t - n];
                }
            }
            dp[t] = count;
        }
        return dp[target];
    }
}
