package practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    public static void main(String[] args) {
        _01Matrix obj = new _01Matrix();
        display(obj.updateMatrix(new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        }));
    }

    private static void display(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        while (q.size() > 0) {
            int[] t = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = t[0] + dirs[i];
                int y = t[1] + dirs[i + 1];
                if (x >= 0 && x < n && y >=0 && y < m && ans[x][y] == -1) {
                    ans[x][y] = ans[t[0]][t[1]] + 1;
                    q.offer(new int[]{x,y});
                }
            }
        }
        return ans;
    }
}
