package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostInMazeTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }
        /*
        6
6
0 1 4 2 8 2
4 3 6 5 0 4
1 2 4 1 4 6
2 0 7 3 2 2
3 1 5 9 2 4
2 7 0 8 5 1
         */
        System.out.println(findMinCostTraversal(n, m, matrix));
    }

    private static int findMinCostTraversal(int n, int m, int[][] matrix) {
        int[][] dp = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = matrix[i][j];
                } else if (i == n - 1) {
                    dp[i][j] = matrix[i][j] + dp[i][j + 1];
                } else if (j == m - 1) {
                    dp[i][j] = matrix[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }
        return dp[0][0];
    }
}
