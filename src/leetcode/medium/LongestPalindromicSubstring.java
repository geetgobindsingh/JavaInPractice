package leetcode.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        String res = "";
        for (int g = 0; g < s.length(); ++g) {
            for (int i = 0, j = g; j < s.length(); i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                }
                if (dp[i][j]) {
                    String ss = s.substring(i, j + 1);
                    if (ss.length() > res.length()) {
                        res = ss;
                    }
                }
            }
        }
        return res;
    }
}
