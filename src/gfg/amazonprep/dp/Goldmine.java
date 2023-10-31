package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldmine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        System.out.print(maxGold(n, m, matrix));
    }

    public static int maxGold(int n, int m, int[][] matrix) {
        int[][] dp = new int[n][m];
        for (int j = m - 1; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                if (j == m - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (i == 0) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i + 1][j + 1], dp[i][j + 1]);
                } else if (i == n - 1) {
                    dp[i][j] = matrix[i][j] + Math.max(dp[i - 1][j + 1], dp[i][j + 1]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.max(Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]), dp[i][j + 1]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i][0]);
        }
        for (int i =0; i < n;i++) {
            for (int j =0; j < m;j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.print("\n");
        }
        return max;
    }


}
