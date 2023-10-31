package gfg.amazonprep.dp;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String A = "ABCDGH";
        String B = "AEDFHR";
        System.out.println(longestCommonSubSequence(A.length(), B.length(), A, B));
        System.out.println(lcs(A.length(), B.length(), A, B));
    }

    static int longestCommonSubSequence(int p, int q, String s1, String s2) {
        int dp[][] = new int[p + 1][q + 1];
        for (int i = p - 1; i >= 0; i--) {
            for (int j = q - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][0];
    }

    static int lcs(int p, int q, String s1, String s2) {
        int matrix[][] = new int[p + 1][q + 1];
        for (int i = 1; i <= p; i++) {
            for (int j = 1; j <= q; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    matrix[i][j] = 1 + matrix[i - 1][j - 1];
                } else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
                }
            }
        }
        return matrix[p][q];
    }
}
