package leetcode.medium;
import java.util.*;
public class ShortestPathVisitingAllNodes {
    public static void main(String[] args) {
        ShortestPathVisitingAllNodes obj = new ShortestPathVisitingAllNodes();
        System.out.println(obj.shortestPathLength(new int[][]{
                {1,2,3}, {0}, {0}, {0}
        }));
        System.out.println(obj.shortestPathLength(new int[][]{
                {1},{0,2,4}, {1,3,4}, {2}, {1,2}
        }));
        System.out.println(obj.shortestPathLengthBFS(new int[][]{
                {1,2,3}, {0}, {0}, {0}
        }));
        System.out.println(obj.shortestPathLengthBFS(new int[][]{
                {1},{0,2,4}, {1,3,4}, {2}, {1,2}
        }));
    }

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][1 << n];
        for (int i = 0; i < n; ++i) {
            q.offer(new int[] {i, 1 << i});
            visited[i][1 << i] = true;
        }
        for (int ans = 0;; ++ans) {
            for (int k = q.size(); k > 0; --k) {
                int[] p = q.poll();
                int i = p[0], st = p[1];
                if (st == (1 << n) - 1) {
                    return ans;
                }
                for (int j : graph[i]) {
                    int nst = st | 1 << j;
                    if (!visited[j][nst]) {
                        visited[j][nst] = true;
                        q.offer(new int[] {j, nst});
                    }
                }
            }
        }
    }

    public static class Pair {
        int val;

        int visited;
        String psf;
        public Pair(int val, int visited, String psf) {
            this.val = val;
            this.visited = visited;
            this.psf = psf;
        }

    }

//    public int shortestPathLength(int[][] graph) { // hamiltonian path - dfs
//        HashSet<Integer> visited = null;
//        for (int v = 0; v < graph.length; v++) {
//            visited = new HashSet<>();
//            traverse(graph, v, visited, v + "");
//        }
//        return -1;
//    }
//
//    public void traverse(int[][] graph, int src, HashSet<Integer> visited, String psf) {
//        if (visited.size() == (graph.length - 1)) {
//            System.out.println(psf);
//        }
//        visited.add(src);
//        for (int v : graph[src]) {
//            if (!visited.contains(v)) {
//                traverse(graph, v, visited, psf + ", " + v);
//            }
//        }
//        visited.remove(src);
//    }

//    public int shortestPathLength(int[][] graph) { // dfs
//        for (int v = 0; v < graph.length; v++) {
//            dfs(graph, v);
//            System.out.print("\n");
//        }
//        return -1;
//    }
//
//    public void dfs(int[][] graph, int src) {
//        Stack<Pair> st = new Stack<>();
//        st.push(new Pair(src,0,src + ""));
//        int[] visited = new int[graph.length];
//        HashSet<Integer> set = new HashSet<>();
//        while (st.size() > 0) {
//            Pair p = st.pop();
//            set.add(p.val);
//            if (visited[p.val] == (graph[p.val].length)) continue;
//            visited[p.val]++;
//            System.out.println(p.psf);
//            if (set.size() == graph.length) {
//                break;
//            }
//            for (int v : graph[p.val]) {
//                if (visited[v] != (graph[v].length)) {
//                    st.push(new Pair(v, visited[v], p.psf + ", " + v));
//                }
//            }
//        }
//    }
    public int shortestPathLengthBFS(int[][] graph) { // bfs
        for (int v = 0; v < graph.length; v++) {
            bfs(graph, v);
            System.out.print("\n");
        }
        return -1;
    }

    public void bfs(int[][] graph, int src) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.visited, o2.visited);
            }
        });
        pq.offer(new Pair(src,  0,src + ""));
        int[] visited = new int[graph.length];
        HashSet<Integer> set = new HashSet<>();
        while (pq.size() > 0) {
            for (int i = 0; i < pq.size(); i++) {
                Pair p = pq.poll();
                set.add(p.val);
                if (visited[p.val] == graph[p.val].length) continue;
                visited[p.val]++;
                System.out.println(p.psf);
                if (set.size() == graph.length) {
                    break;
                }
                for (int v : graph[p.val]) {
                    if (visited[v] != graph[v].length) {
                        pq.offer(new Pair(v,  visited[v],p.psf + "," + v));
                    }
                }

            }
        }
    }
}
