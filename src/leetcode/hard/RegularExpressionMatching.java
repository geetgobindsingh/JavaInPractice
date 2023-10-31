package leetcode.hard;

public class RegularExpressionMatching {
    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     *
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     *
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     * Example 1:
     *
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     *
     * Input:
     * s = "aa"
     * p = "a*"
     * Output: true
     * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
     * Example 3:
     *
     * Input:
     * s = "ab"
     * p = ".*"
     * Output: true
     * Explanation: ".*" means "zero or more (*) of any character (.)".
     * Example 4:
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
     * Example 5:
     *
     * Input:
     * s = "mississippi"
     * p = "mis*is*p*."
     * Output: false
     */
    public static void main(String[] args) {
        RegularExpressionMatching obj = new RegularExpressionMatching();
        System.out.println(obj.isMatch("aa", ".*"));
    }

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0 || j == 0) {
                    if (j == 0) {
                        char c = p.charAt(i - 1);
                        if (c == '*') {
                            dp[i][j] = dp[i - 2][j];
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    char c = p.charAt(i - 1);
                    if (c == '.') {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else if (c == '*') {
                        if (p.charAt(i - 2) == '.') {
                            dp[i][j] = (dp[i - 2][j] || dp[i][j - 1]);
                        } else {
                            if (p.charAt(i - 2) == s.charAt(j - 1)) {
                                dp[i][j] = (dp[i - 2][j] || dp[i][j - 1]);
                            } else {
                                dp[i][j] = dp[i - 2][j];
                            }
                        }
                    } else {
                        if (c == s.charAt(j - 1)) {
                            dp[i][j] = dp[i - 1][j - 1];
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }
        for (boolean[] b : dp) {
            for (boolean bb : b) {
                System.out.print(bb + " ");
            }
            System.out.print("\n");
        }
        return dp[m][n];
    }
}
