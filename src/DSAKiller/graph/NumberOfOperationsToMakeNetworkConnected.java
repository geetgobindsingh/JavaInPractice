package DSAKiller.graph;

import java.util.ArrayList;
import java.util.HashMap;

//TODO: @difficult
public class NumberOfOperationsToMakeNetworkConnected {

    public static void main(String[] args) {
        int[][] connections = new int[][]{
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 2},
                {1, 3},
        };
        System.out.print(makeConnected(6, connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < (n - 1)) return -1;
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            ArrayList<Integer> adjList = graph.get(connections[i][0]);
            adjList.add(connections[i][1]);
            adjList = graph.get(connections[i][1]);
            adjList.add(connections[i][0]);
        }

        int components = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            components = components + dfs(i, graph, visited);
        }
        return components - 1;
    }

    private static int dfs(int v, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
        if (visited[v]) return 0;
        visited[v] = true;
        for (Integer u : graph.get(v)) {
            dfs(u, graph, visited);
        }
        return 1;
    }
}
