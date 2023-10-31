package leetcode.medium;

public class PredictTheWinner {
    public static void main(String[] args) {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(PredictTheWinner(new int[]{1, 5, 223, 7}));
        System.out.println(PredictTheWinner(new int[]{1, 5, 2, 4, 6}));
        System.out.println(PredictTheWinner(new int[]{3606449, 6, 5, 9, 452429, 7,
                9580316, 9857582, 8514433, 9, 6, 6614512,
                753594, 5474165, 4, 2697293, 8, 7, 1}));
    }

    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = nums[i];
                }
            }
        }
        return score(nums, 0, n - 1, dp) >= 0;
    }

    private static int score(int[] nums, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = nums[i] - score(nums, i + 1, j, dp);
        int right = nums[j] - score(nums, i, j - 1, dp);
        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }

    public static boolean PredictTheWinner2(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int sumA = 0;
        int sumB = 0;
        while (i <= j) {
            if (i == j) {
                sumA = sumA + nums[i];
                return sumA >= sumB;
            }
            if (indexPicked(nums, i, j) == i) {
                sumA = sumA + nums[i];
                i++;
                if (i == j) {
                    sumB = sumB + nums[i];
                    return sumA >= sumB;
                }
                if (indexPicked(nums, i, j) == i) {
                    sumB = sumB + nums[i];
                    i++;
                } else {
                    sumB = sumB + nums[j];
                    j--;
                }
            } else {
                sumA = sumA + nums[j];
                j--;
                if (i == j) {
                    sumB = sumB + nums[i];
                    return sumA >= sumB;
                }
                if (indexPicked(nums, i, j) == i) {
                    sumB = sumB + nums[i];
                    i++;
                } else {
                    sumB = sumB + nums[j];
                    j--;
                }
            }
        }
        return sumA >= sumB;
    }

    private static int indexPicked(int[] nums, int i, int j) {
        if (i == j) {
            return i;
        }
        int leftMost = nums[i];
        int secondLeftMost = nums[i + 1];
        int rightMost = nums[j];
        int secondRightMost = nums[j - 1];

        if ((leftMost + secondRightMost) >= (rightMost + secondLeftMost)) {
            return i;
        } else {
            return j;
        }
    }
}
