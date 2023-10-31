package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountBinaryStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (0 < n && n <= 45) {
            System.out.print(numberOfBinaryStrings(n));
        }
    }

     /*
    in: 6
    out : 21
     */


    //Without Space
    private static int numberOfBinaryStrings(int n) {
        if (n == 0) return 0;
        int numberOfZeroes = 1;
        int numberOfOnes = 1;
        for (int i = 2; i <= n; i++) {
            int numZero = numberOfOnes;
            int numOne = numberOfZeroes + numberOfOnes;
            numberOfZeroes = numZero;
            numberOfOnes = numOne;
        }
        return numberOfOnes + numberOfZeroes;
    }

    // With Space
    private static int numberOfBinaryStrings1(int n) {
        int[][] dp = new int[2][n + 1];
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp[0][1] = 1;
        dp[1][1] = 1;
        for (int j = 2; j <= n; j++) {
            for (int i = 0; i < 2; i++) {
                dp[0][j] = dp[1][j - 1];
                dp[1][j] = dp[0][j - 1] + dp[1][j - 1];
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.print("\n");
        }

        return dp[0][n] + dp[1][n];
    }
}
