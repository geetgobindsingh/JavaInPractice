package leetcode.medium;

public class UniquePathsII {
    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        }));
        System.out.println(uniquePathsWithObstacles(new int[][]{
                {0, 1},
                {0, 0}
        }));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        long dp[][] = new long[m][n];
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                if (i == m - 1 && j == n - 1 && obstacleGrid[i][j] == 0) {
                    dp[i][j] = 1;
                } else if (obstacleGrid[i][j] == 0) {
                    long bottom = 0;
                    if (i + 1 < m && obstacleGrid[i + 1][j] == 0) {
                        bottom = dp[i + 1][j];
                    }
                    long right = 0;
                    if (j + 1 < n && obstacleGrid[i][j + 1] == 0) {
                        right = dp[i][j + 1];
                    }
                    dp[i][j] = right + bottom;
                }
            }
        }
        return (int) (dp[0][0] % (1000_000_000 * 2));
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int MOD = 1000_000_000 * 2;
        return totalObstacles2(0, 0, obstacleGrid, "", MOD);
    }

    private static int totalObstacles2(int r, int c, int[][] obstacleGrid, String asf, int MOD) { // Worst case due to overlalpping > O(N2)
        if (r >= obstacleGrid.length || c >= obstacleGrid[0].length || obstacleGrid[r][c] == 1 || asf.length() > MOD) {
            return 0;
        }
        if (r == obstacleGrid.length - 1 && c == obstacleGrid[0].length - 1) {
            return 1;
        }
        int down = totalObstacles2(r + 1, c, obstacleGrid, asf + "d", MOD) % MOD;
        int right = totalObstacles2(r, c + 1, obstacleGrid, asf + "v", MOD) % MOD;
        return (down + right) / MOD;
    }
}
