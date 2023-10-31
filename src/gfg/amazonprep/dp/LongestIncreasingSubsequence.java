package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }
//        int ar[] = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.print(longestSubsequence(ar.length, ar));
    }

    public static long longestSubsequence(int n, int a[]) {
        int dp[] = new int[n];
        int MAX = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }
            dp[i] = max + 1;
            if (dp[i] > MAX) {
                MAX = dp[i];
            }
        }
        return MAX;
    }

    public static int longestSubsequenc1(int size, int a[]) {
        int matrix[] = new int[size];
        Arrays.fill(matrix, 1);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i] && matrix[i] < (matrix[j] + 1)) {
                    matrix[i] = (matrix[j] + 1);
                }
            }
        }
        int maxLength = 1;
        for (int i = 0; i < size; i++) {
            if (matrix[i] > maxLength) {
                maxLength = matrix[i];
            }
        }
        return maxLength;
    }
}
