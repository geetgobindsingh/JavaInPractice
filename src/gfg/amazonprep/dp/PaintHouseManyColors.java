package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/paint-house-many-colors-official/ojquestion
public class PaintHouseManyColors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ar = br.readLine().split(" ");
        int n = Integer.parseInt(ar[0]);
        int k = Integer.parseInt(ar[1]);
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            ar = br.readLine().split(" ");
            for (int j = 0; j < k; j++) {
                matrix[i][j] = Integer.parseInt(ar[j]);
            }
        }
        System.out.print(findMinCostOfPainting(n, k, matrix));
    }


    // Best solution with O(n^2) and lesser memory footprint
    private static long findMinCostOfPainting(int n, int k, int[][] matrix) {
        long[][] dp = new long[n][k];
        long least = Long.MAX_VALUE;
        long secondLeast = Long.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            dp[0][i] = matrix[0][i];
            if (dp[0][i] < least) {
                secondLeast = least;
                least = dp[0][i];
            } else if (dp[0][i] < secondLeast) {
                secondLeast = dp[0][i];
            }
        }
        for (int i = 1; i < n; i++) {
            long newLeast = Long.MAX_VALUE;
            long newSecondLeast = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (least == dp[i - 1][j]) {
                    dp[i][j] = secondLeast + matrix[i][j];
                } else {
                    dp[i][j] = least + matrix[i][j];
                }
                if (dp[i][j] <= newLeast) {
                    newSecondLeast = newLeast;
                    newLeast = dp[i][j];
                } else if (dp[i][j] < newSecondLeast) {
                    newSecondLeast = dp[i][j];
                }
            }
            least = newLeast;
            secondLeast = newSecondLeast;
        }

        return least;
    }

    // This is working but not best solution, lesser memory footprint but O(n^3)
    private static long findMinCostOfPainting2(int n, int k, int[][] matrix) {
        long[][] dp = new long[n][k];
        for (int i = 0; i < k; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                long newColorVal = Long.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        newColorVal = Math.min(newColorVal, dp[i - 1][l]);
                    }
                }
                dp[i][j] = newColorVal + matrix[i][j];
            }
        }
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }
        return minCost;
    }

    // this is working solution but out of memory due to copy array may be
    private static long findMinCostOfPainting1(int n, int k, int[][] matrix) {
        long[] colors = new long[k];
        for (int i = 0; i < k; i++) {
            colors[i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            long[] oldColors = colors.clone();
            for (int j = 0; j < k; j++) {
                long newColorVal = Long.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    if (l != j) {
                        newColorVal = Math.min(newColorVal, oldColors[l]);
                    }
                }
                colors[j] = newColorVal + matrix[i][j];
            }
        }
        long minCost = Long.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            minCost = Math.min(minCost, colors[i]);
        }
        return minCost;
    }
}
