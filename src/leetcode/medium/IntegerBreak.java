package leetcode.medium;

public class IntegerBreak {
    public static void main(String[] args) {
        IntegerBreak obj = new IntegerBreak();
        System.out.println(obj.integerBreak(2));
        System.out.println(obj.integerBreak(3));
        System.out.println(obj.integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 1; j--) {
                max = Math.max(max, Math.max((i - j) * j, (i - j) * dp[j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
