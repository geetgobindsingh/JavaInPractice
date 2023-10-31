package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/partition-into-subsets-official/ojquestion
public class PartitionIntoSubsets {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        System.out.print(numberOfPartitioning(n, k));
    }

    private static long numberOfPartitioning(int n, int k) {
        if (n == 0 || k == 0 || n < k) {
            return 0;
        }
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i) {
                    dp[i][j] = 0;
                } else if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + ((i) * dp[i][j - 1]);
                }
            }
        }
//        for (int i = 0; i <= k; i++) {
//            for (int j = 0; j <= n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
        return dp[k][n];
    }

}
