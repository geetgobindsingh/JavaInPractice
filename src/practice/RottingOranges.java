package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();
        System.out.println(obj.orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
        System.out.println(obj.orangesRotting(new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        }));
        System.out.println(obj.orangesRotting(new int[][]{
                {0, 2}
        }));
        System.out.println(obj.orangesRotting(new int[][]{
                {0}
        }));
        System.out.println(obj.orangesRotting(new int[][]{
                {1}
        }));
        System.out.println(obj.orangesRotting(new int[][]{
                {2}
        }));
    }

    public int orangesRotting(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int freshCount = 0;
        int time = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
                if (a[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        while (q.size() > 0 && freshCount > 0) {
            time = time + 1;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] p = q.poll();
                a[p[0]][p[1]] = -1;
                for (int j = 0; j < 4; j++) {
                    int x = p[0] + dirs[j];
                    int y = p[1] + dirs[j + 1];
                    if (x >= 0 && x < m && y >= 0 && y < n && a[x][y] == 1) {
                        freshCount--;
                        a[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        }
        return freshCount > 0 ? -1 : time;
    }
}
