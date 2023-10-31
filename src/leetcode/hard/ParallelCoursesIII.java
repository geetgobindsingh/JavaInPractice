package leetcode.hard;

import java.util.*;

public class ParallelCoursesIII {
    public static void main(String[] args) {
        ParallelCoursesIII obj = new ParallelCoursesIII();
        System.out.println(obj.minimumTime(2, new int[][]{{2, 1}}, new int[]{10000, 10000}));
        System.out.println(obj.minimumTime(3, new int[][]{{1, 3}, {2, 3}}, new int[]{3, 2, 5}));
        System.out.println(obj.minimumTime(5, new int[][]{{1, 5}, {2, 5}, {3, 5}, {3, 4}, {4, 5}}, new int[]{1, 2, 3, 4, 5}));
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] e : relations) {
            int a = e[0] - 1, b = e[1] - 1;
            g[a].add(b);
            ++indeg[b];
        }
        Deque<Integer> q = new ArrayDeque<>();
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int v = indeg[i], t = time[i];
            if (v == 0) {
                q.offer(i);
                dp[i] = t;
                ans = Math.max(ans, t);
            }
        }
        while (!q.isEmpty()) {
            int i = q.pollFirst();
            for (int j : g[i]) {
                dp[j] = Math.max(dp[j], dp[i] + time[j]);
                ans = Math.max(ans, dp[j]);
                if (--indeg[j] == 0) {
                    q.offer(j);
                }
            }
        }
        return ans;
    }
    public int minimumTime1(int n, int[][] relations, int[] time) { //wrong solution
        if (relations.length == 0) {
            int max = 0;
            for (int t : time) {
                max = Math.max(max, t);
            }
            return max;
        }
        int[] graph = new int[n + 1];
        Arrays.fill(graph, -1);
        int[] inDegrees = new int[n + 1];
        for (int i = 0; i < relations.length; i++) {
            int start = relations[i][0];
            int end = relations[i][1];
            if (graph[start] == -1 || graph[start] > end) {
                graph[start] = end;
            }
            inDegrees[end]++;
        }
        int max = 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int v = q.poll();
            int u = graph[v];
            if (u == -1) {
                continue;
            }
            if (--inDegrees[u] == 0) {
                q.offer(u);
            }
            dp[v] = traverse(v, dp, graph, time);
            max = Math.max(max, dp[v]);
        }
        return max;
    }

    private int traverse(int s, int[] dp, int[] graph, int[] time) {
        if (s == -1) {
            return 0;
        }
        if (dp[s] != -1) {
            return dp[s];
        }
        if (graph[s] == -1) {
            return time[s - 1];
        }
        dp[s] = time[s - 1] + traverse(graph[s], dp, graph, time);
        return dp[s];
    }
}
