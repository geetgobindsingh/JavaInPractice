package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/min-squares-official/ojquestion
public class MinSquares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.print(minimumNumberOfSquaresThatSumToN(n));
    }

    public static long minimumNumberOfSquaresThatSumToN(int n) {
        long dp[] = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = 1; (j*j) <= i; j++) {
                int rem = i - (j*j);
                if (dp[rem] < min) {
                    min = dp[rem];
                }
            }
            dp[i] = min + 1;
        }
        return dp[n];
    }
}
