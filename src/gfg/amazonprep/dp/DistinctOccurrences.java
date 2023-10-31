package gfg.amazonprep.dp;

public class DistinctOccurrences {
    public static void main(String[] args) {
        System.out.print(subsequenceCount("babk", "b"));
    }

    public static long subsequenceCount(String S, String T) { // DP
        if (T.length() > S.length()) {
            return 0;
        }
        int mod = 1000000007;
        long[][] matrix = new long[T.length() + 1][S.length() + 1];
        for (int i = 0; i < (T.length() + 1); i++) {
            matrix[i][0] = 0L;
        }
        for (int i = 0; i < (S.length() + 1); i++) {
            matrix[0][i] = 1L;
        }
        for (int i = 1; i < (T.length() + 1); i++) {
            for (int j = 1; j < (S.length() + 1); j++) {
                if (T.charAt(i - 1) == S.charAt(j - 1)) {
                    matrix[i][j] = (matrix[i][j - 1] % mod + matrix[i - 1][j - 1] % mod) % mod;
                } else {
                    matrix[i][j] = matrix[i][j - 1] % mod;
                }
            }
        }
        return matrix[T.length()][S.length()] % mod;
    }

    public static int subSequenceR(String S, String T, int n, int m) { // recursive
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && S.charAt(n) == T.charAt(m)) {
            return 1 + subSequenceR(S, T, n - 1, m);
        }
        if (S.charAt(n) == T.charAt(m)) {
            return subSequenceR(S, T, n - 1, m - 1) + subSequenceR(S, T, n - 1, m);
        } else {
            return subSequenceR(S, T, n - 1, m);
        }
    }
}
