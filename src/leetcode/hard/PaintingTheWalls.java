package leetcode.hard;

import java.util.Arrays;

public class PaintingTheWalls {
    public static void main(String[] args) {
        PaintingTheWalls obj = new PaintingTheWalls();
        System.out.println(obj.paintWalls(new int[]{1, 2, 3, 2}, new int[]{1, 2, 3, 2}));
        System.out.println(obj.paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
        System.out.println(obj.paintWalls(new int[]{26, 53, 10, 24, 25, 20, 63, 51}, new int[]{1, 1, 1, 1, 2, 2, 2, 1}));
        /*
        26, 53, 10, 24, 25, 20, 63, 51
        1,   1,  1,  1,  2,  2,  2,  1

        cost: (0,10) 10, (6, 63) 10, (5,20) 30, (1, 53) 30, (7, 51) 30, (2, 24) 54, (0, 26) 54, (4, 25) 79
        Time: 1,1, 2, 2, 1, 1, 2, 1
         */
    }

    public int paintWalls(int[] cost, int[] time) { // DP
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1000_000 * 500);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int walls = n; walls > 0; --walls) {
                int remainingWallsIfWePick = walls - (time[i] + 1);
                int pick = cost[i] + dp[Math.max(remainingWallsIfWePick, 0)];
                int skip = dp[walls];
                dp[walls] = Math.min(pick, skip);
            }
        }
        return dp[n];
    }

    public int paintWalls1(int[] cost, int[] time) { // wrong solution
        int n = cost.length;
        boolean[] visited = new boolean[n];
        int tc = 0;
        for (int i = 0; i < n; i++) {
            int minIndex = findMin(visited, cost, time);
            if (minIndex == -1) {
                break;
            }
            visited[minIndex] = true;
            int t = time[minIndex];
            tc = tc + cost[minIndex];
            while (t > 0) {
                int maxIndex = findMax(visited, cost);
                if (maxIndex == -1) {
                    break;
                }
                visited[maxIndex] = true;
                t = t - 1;
            }
        }
        return tc;
    }

    private int findMin(boolean[] visited, int[] cost, int[] time) {
        int maxTime = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i]) {
                if (maxTime < time[i] && min > cost[i]) {
                    min = cost[i];
                    maxTime = time[i];
                    minIndex = i;
                } else if (min > cost[i]) {
                    min = cost[i];
                    maxTime = time[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    private int findMax(boolean[] visited, int[] cost) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < cost.length; i++) {
            if (!visited[i]) {
                if (max < cost[i]) {
                    max = cost[i];
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }
}
