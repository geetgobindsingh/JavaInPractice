package gfg.amazonprep.dp;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        MatrixChainMultiplication obj = new MatrixChainMultiplication();
        System.out.println(obj.matrixChainOrder(new int[]{2, 3, 4, 5}));
        System.out.println(obj.matrixChainOrder(new int[]{40, 20, 30, 10, 30}));
        System.out.println(obj.matrixChainOrder(new int[]{1, 2, 3, 4, 3}));
        System.out.println(obj.matrixChainOrder(new int[]{1, 2, 3, 4, 5}));
    }

    public long matrixChainOrder(int p[]) {
        int n = p.length;
        long[][] dp = new long[n - 1][n - 1];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 0;
                } else if (g == 1) {
                    dp[i][j] = (long) p[i] * p[j] * p[j + 1];
                } else {
                    long min = Long.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        long lc = dp[i][k];
                        long rc = dp[k + 1][j];
                        long mc = (long) p[i] * p[k + 1] * p[j + 1];
                        long cal = lc + rc + mc;
                        min = Math.min(min, cal);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
