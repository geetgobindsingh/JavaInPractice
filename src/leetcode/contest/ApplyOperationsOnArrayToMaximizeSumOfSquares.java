package leetcode.contest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ApplyOperationsOnArrayToMaximizeSumOfSquares {
    public static void main(String[] args) {
        ApplyOperationsOnArrayToMaximizeSumOfSquares obj = new ApplyOperationsOnArrayToMaximizeSumOfSquares();
        System.out.println(obj.maxSum(Arrays.asList(2,6,5,8), 2));
    }

    public int maxSum(List<Integer> nums, int k) {
        int size = nums.size();
        int[][] dp = new int[size][size];
        int max = 0;
        for (int g = 0; g < size; ++g) {
            for (int i = 0, j = g; j < size; ++i, ++j) {
                if (g == 0) {
                    dp[i][j] = nums.get(i) * nums.get(j);
                } else if (g == 1) {
                    dp[i][j] = Math.max((nums.get(i) + nums.get(j)) * (nums.get(i) + nums.get(j)), dp[i][j - 1] + dp[i + 1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
