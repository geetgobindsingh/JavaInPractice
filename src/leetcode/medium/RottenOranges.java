package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1},
        }));
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int total1s = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    total1s++;
                } else if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
            }
        }
        Queue<Pair> q2 = new LinkedList<>();
        int[] dirs = {1, 0, -1, 0, 1};
        int ans = 0;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < dirs.length - 1; i++) {
                int x = p.x + dirs[i];
                int y = p.y + dirs[i + 1];
                if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1) {
                    total1s--;
                    grid[x][y] = 2;
                    q2.offer(new Pair(x, y));
                }
            }

            if (q.size() == 0) {
                if (q2.size() > 0) {
                    ans++;
                    q.addAll(q2);
                    q2 = new LinkedList<>();
                }
            }
        }

        return (total1s > 0) ? -1 : ans;
    }
}
