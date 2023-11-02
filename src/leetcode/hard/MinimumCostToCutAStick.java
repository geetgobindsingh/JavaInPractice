package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {
    public static void main(String[] args) {
        MinimumCostToCutAStick obj = new MinimumCostToCutAStick();
        System.out.println(obj.minCost(7, new int[]{1, 3, 4, 5}));
        System.out.println(obj.minCost(5, new int[]{1, 2, 3}));
    }

    public int minCost(int n, int[] cuts) {
        List<Integer> nums = new ArrayList<>();
        for (int x : cuts) {
            nums.add(x);
        }
        nums.add(0);
        nums.add(n);
        Collections.sort(nums);
        int m = nums.size();
        int[][] dp = new int[m][m];
        for (int l = 2; l < m; ++l) {
            for (int i = 0; i + l < m; ++i) {
                int j = i + l;
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; ++k) {
                    int lc = dp[i][k];
                    int rc = dp[k][j];
                    int mc = nums.get(j) - nums.get(i);
                    min = Math.min(min, lc + rc + mc);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][m - 1];
    }

}