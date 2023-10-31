package leetcode.medium;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _01Matric {
    public static void main(String[] args) {
//        int ar[][] = new int[][]{
//                {1,0,1,1,0,0,1,0,0,1},
//                {0,1,1,0,1,0,1,0,1,1},
//                {0,0,1,0,1,0,0,1,0,0},
//                {1,0,1,0,1,1,1,1,1,1},
//                {0,1,0,1,1,0,0,0,0,1},
//                {0,0,1,0,1,1,1,0,1,0},
//                {0,1,0,1,0,1,0,0,1,1},
//                {1,0,0,0,1,1,1,1,0,1},
//                {1,1,1,1,1,1,1,0,1,0},
//                {1,1,1,1,0,1,0,0,1,1}};
        int ar[][] = new int[][]{
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0}};
        for (int[] a : ar) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int[] a : updateMatrix(ar)) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        for (int[] a : updateMatrix2(ar)) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }

    }

    public static int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(ans[i], -1);
        }
        Deque<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int i = 0; i < 4; ++i) {
                int x = t[0] + dirs[i];
                int y = t[1] + dirs[i + 1];
                if (x >= 0 && x < m && y >= 0 && y < n && ans[x][y] == -1) {
                    ans[x][y] = ans[t[0]][t[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return ans;
    }

    public static int[][] updateMatrix2(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = getDist(i, j, mat, dp, visited);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }

    public static int getDist(int r, int c, int[][] mat, int[][] dp,
                              boolean[][] visited) { // this is DFS therefor it wont work
        if (r < 0 || c < 0 || r >= mat.length || c >= mat[0].length) { // negative base case
            return 100_000;
        }
        if (mat[r][c] == 0) { // positive base case
            return 0;
        }
        if (dp[r][c] != -1) { // positive base case
            return dp[r][c];
        }
        if (visited[r][c]) {
            return 100_000;
        }
        visited[r][c] = true;
        int left = getDist(r, c - 1, mat, dp, visited);
        int top = getDist(r - 1, c, mat, dp, visited);
        int right = getDist(r, c + 1, mat, dp, visited);
        int bottom = getDist(r + 1, c, mat, dp, visited);
        visited[r][c] = false;
        int minDist = Math.min(left, Math.min(top, Math.min(right, bottom)));
        dp[r][c] = 1 + minDist;
        return dp[r][c];
    }
}
