package gfg.amazonprep.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPalindromeSubSequences {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        System.out.println(longestPalindromicSubSequence(a));
    }

    private static int longestPalindromicSubSequence(String a) {
        int[][] dp = new int[a.length()][a.length()];
        int counter = 0;
        for (int gap = 0; gap < a.length(); gap++) {
            for (int i = 0, j = gap; j < a.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = a.charAt(i) == a.charAt(j) ? 2 : 1;
                } else {
                    if (a.charAt(i) == a.charAt(j)) {
                        dp[i][j] =  dp[i][j - 1] +  dp[i + 1][j] - 1;
                    } else {
                        dp[i][j] =  dp[i][j - 1] +  dp[i + 1][j] - dp[i + 1][j - 1];
                    }
                }
            }
        }
        return counter;
    }
}
