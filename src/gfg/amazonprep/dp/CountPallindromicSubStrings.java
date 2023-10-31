package gfg.amazonprep.dp;

import java.util.Scanner;

public class CountPallindromicSubStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(longestPalindromicSubStrings(a));
    }

    private static int longestPalindromicSubStrings(String a) {
        int[][] dp = new int[a.length()][a.length()];
        for (int gap = 0; gap < a.length(); gap++) {
            for (int i = 0, j = gap; j < a.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = a.charAt(i) == a.charAt(j) ? 2 : 1;
                } else {
                    if (a.charAt(i) == a.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][a.length() - 1];
    }


}
