package gfg.amazonprep.dp;

public class LongestPalindromeSubstring {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaabbaa"));
        System.out.println(longestPalindromicSubStrings("aaaabbaa"));
        System.out.println(longestPalindrome("qrrc"));
        System.out.println(longestPalindromicSubStrings("qrrc"));
    }

    public static int longestPalindromicSubStrings(String a) {
        boolean[][] dp = new boolean[a.length()][a.length()];
        int length = 0;
        for (int gap = 0; gap < a.length(); gap++) {
            for (int i = 0, j = gap; j < a.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = a.charAt(i) == a.charAt(j);
                } else {
                    if (a.charAt(i) == a.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
                if (dp[i][j]) {
                    length = gap + 1;
                }
            }
        }
        return length;
    }


    public static String longestPalindrome(String s) { // O(N)
        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - ((len - 1) / 2);
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        if (s == null || left > right)
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static String longestPalindrome1(String S) { //O (N^2)
        int[][] palindrome = new int[S.length()][S.length()];
        int a = 0;
        int b = 0;
        int max = 0;
        for (int g = 0; g < S.length(); g++) {
            for (int i = 0, j = g; j < S.length(); i++, j++) {
                if (g == 0) {
                    palindrome[i][j] = 1;
                } else if (g == 1 && S.charAt(i) == S.charAt(j)) {
                    palindrome[i][j] = 2;
                    if (max < palindrome[i][j]) {
                        max = palindrome[i][j];
                        a = i;
                        b = j;
                    }
                } else {
                    if (S.charAt(i) == S.charAt(j)
                            && palindrome[i + 1][j - 1] > 0) {
                        palindrome[i][j] = palindrome[i + 1][j - 1] + 2;
                        if (max < palindrome[i][j]) {
                            max = palindrome[i][j];
                            a = i;
                            b = j;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                System.out.print(palindrome[i][j] + " ");
            }
            System.out.print("\n");
        }
        return S.substring(a, b + 1);
    }
}
