package leetcode.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumScoreOfAGoodSubarray {
    public static void main(String[] args) {
        MaximumScoreOfAGoodSubarray obj = new MaximumScoreOfAGoodSubarray();
        System.out.println(obj.maximumScore(new int[]{1, 4, 3, 7, 4, 5}, 3));
    }

    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, n);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] >= v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        stk.clear();
        for (int i = n - 1; i >= 0; --i) {
            int v = nums[i];
            while (!stk.isEmpty() && nums[stk.peek()] > v) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                right[i] = stk.peek();
            }
            stk.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            if (left[i] + 1 <= k && k <= right[i] - 1) {
                ans = Math.max(ans, nums[i] * (right[i] - left[i] - 1));
            }
        }
        return ans;
    }

    public int maximumScore1(int[] nums, int k) { // MLE
        int n = nums.length;
        int[][] minar = new int[n][n];
        for (int g = 0; g < n; ++g) {
            for (int i = 0, j = g; j < n; ++i, ++j) {
                if (g == 0) {
                    minar[i][j] = nums[i];
                } else {
                    minar[i][j] = Math.min(minar[i + 1][j], minar[i][j - 1]);
                }
            }
        }
        int[][] score = new int[n][n];
        for (int g = 0; g < n; ++g) {
            for (int i = 0, j = g; j < n; ++i, ++j) {
                if (g == 0) {
                    score[i][j] = minar[i][j] * (j - i + 1);
                } else {
                    score[i][j] = (Math.min(minar[i + 1][j], minar[i][j - 1])) * (j - i + 1);
                }
            }
        }
        int max = 0;
        for (int g = 0; g < n; ++g) {
            for (int i = 0, j = g; j < n; ++i, ++j) {
                if (i <= k & k <= j) {
                    max = Math.max(max, score[i][j]);
                }
            }
        }
        return max;
    }
}
