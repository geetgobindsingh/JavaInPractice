package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/dynamic-programming/msis-official/ojquestion
public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
        System.out.print(maxSumOfSubSequence(ar.length, ar));
    }

    private static long maxSumOfSubSequence(int length, int[] ar) {
        int maxSum = 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                if (ar[j] <= ar[i]) {
                    if (dp[j] > sum) {
                        sum = dp[j];
                    }
                }
            }
            dp[i] = sum + ar[i];
            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }
        return maxSum;
    }


}
