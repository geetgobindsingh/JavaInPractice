package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class KnightDialer {
    public static void main(String[] args) {
        KnightDialer obj = new KnightDialer();
        System.out.println(obj.knightDialer(1));
        System.out.println(obj.knightDialer(2));
    }

    public int knightDialer(int n) {
        int[][] grid = new int[4][3];
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 3;
        grid[1][0] = 4;
        grid[1][1] = 5;
        grid[1][2] = 6;
        grid[2][0] = 7;
        grid[2][1] = 8;
        grid[2][2] = 9;
        grid[3][1] = -1;
        grid[3][0] = 0;
        grid[3][2] = -1;
        LinkedHashMap<Integer, Integer[]> map = new LinkedHashMap<>();
        map.put(0, new Integer[]{3, 1});
        map.put(1, new Integer[]{0, 0});
        map.put(2, new Integer[]{0, 1});
        map.put(3, new Integer[]{0, 2});
        map.put(4, new Integer[]{1, 0});
        map.put(5, new Integer[]{1, 1});
        map.put(6, new Integer[]{1, 2});
        map.put(7, new Integer[]{2, 0});
        map.put(8, new Integer[]{2, 1});
        map.put(9, new Integer[]{2, 2});

        int[][] dp = new int[10][n + 1];
        for (int i = 9; i < 10; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 9; i < 10; i++) {
            dp[i][0] = 1;
        }
        int mod = 1000_000_007;

        long count = 0;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            count = (count + traverse(n, entry.getValue()[0], entry.getValue()[1], grid, dp)) % mod;
        }
        return (int) (count % mod);
    }

    private int traverse(int n, int x, int y, int[][] grid, int[][] dp) {
        if (!isValid(x, y) || n == 0) {
            return 0;
        }
        int key = grid[x][y];
        System.out.print(key + " : " + n);
        if (dp[key][n] != -1) {
            return dp[key][n];
        }
        dp[key][n] = 1 + (traverse(n - 1, x - 2, y + 1, grid, dp)
                + traverse(n - 1, x - 2, y - 1, grid, dp)
                + traverse(n - 1, x + 1, y + 2, grid, dp)
                + traverse(n - 1, x - 1, y + 2, grid, dp)
                + traverse(n - 1, x + 1, y - 2, grid, dp)
                + traverse(n - 1, x - 1, y - 2, grid, dp)
                + traverse(n - 1, x + 2, y + 1, grid, dp)
                + traverse(n - 1, x + 2, y - 1, grid, dp)
        );
        return dp[key][n];
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && x < 4 && y >= 0 && y < 3 && !((x == 3 && y == 0) || (x == 3 && y == 2));
    }
}
