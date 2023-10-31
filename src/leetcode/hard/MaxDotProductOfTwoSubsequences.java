package leetcode.hard;

public class MaxDotProductOfTwoSubsequences {
    public static void main(String[] args) {
        MaxDotProductOfTwoSubsequences obj = new MaxDotProductOfTwoSubsequences();
        System.out.println(obj.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        System.out.println(obj.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        System.out.println(obj.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
        System.out.println(obj.maxDotProduct(new int[]{-5, 3, -5, -3, 1}, new int[]{-2, 4, 2, 5, -5}));
        System.out.println(obj.maxDotProduct(new int[]{-3, -8, 3, -10, 1, 3, 9}, new int[]{9, 2, 3, 7, -9, 1, -8, 5, -1, -1}));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int min = -1000 - 1;
        int dp[][] = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 0; i <= nums1.length; ++i) {
            for (int j = 0; j <= nums2.length; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = min;
                } else {
                    int prev = dp[i - 1][j - 1];
                    if (prev < 0) {
                        prev = 0;
                    }
                    dp[i][j] = Math.max(dp[i][j - 1], Math.max(dp[i - 1][j], ((nums1[i - 1] * nums2[j - 1]) + prev)));
                }
            }
        }
        for (int i = 0; i <= nums1.length; ++i) {
            for (int j = 0; j <= nums2.length; ++j) {
                if (dp[i][j] < 0) {
                    System.out.print(dp[i][j] + " ");
                } else {
                    System.out.print(dp[i][j] + "  ");
                }
            }
            System.out.println();
        }
        return dp[nums1.length][nums2.length];
    }

    /*
    for (int i = 0; i <= nums1.length; ++i) {
            for (int j = 0; j <= nums2.length; ++j) {
                if (dp[i][j] < 0) {
                    System.out.print(dp[i][j] + " ");
                } else {
                    System.out.print(dp[i][j] + "  ");
                }
            }
            System.out.println();
        }
     */
}
