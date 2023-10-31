package DSAKiller.graph;

import java.util.*;

public class DetectCycleInAUnDirectedGraph {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> adjList = new ArrayList<>();
        adjList.add(1);
        graph.put(0, adjList);
        adjList = new ArrayList<>();
        adjList.add(0);
        graph.put(1, adjList);
        adjList = new ArrayList<>();
        adjList.add(3);
        graph.put(2, adjList);
        adjList = new ArrayList<>();
        adjList.add(2);
        adjList.add(4);
        graph.put(3, adjList);
        adjList = new ArrayList<>();
        adjList.add(2);
        adjList.add(3);
//        adjList.add(2); // back edge
        graph.put(4, adjList);

        System.out.println(cycleExistUsingBFS(graph));
        System.out.println(cycleExistUsingDFS(graph));
    }

    public static boolean cycleExistUsingBFS(HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);
        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v] && isCycleExistBFS(v, graph, visited, parent)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycleExistBFS(int v,
                                           HashMap<Integer, List<Integer>> graph,
                                           boolean[] visited,
                                           int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            v = queue.poll();
            for (Integer u : graph.get(v)) {
                if (!visited[u]) {
                    parent[u] = v;
                    visited[v] = true;
                    queue.offer(u);
                } else if (u != parent[v]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleExistUsingDFS(HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        int[] parent = new int[graph.size()];
        Arrays.fill(parent, -1);
        for (int v = 0; v < graph.size(); v++) {
            if (!visited[v] && isCycleExistDFS(v, graph, visited, parent)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCycleExistDFS(int v,
                                           HashMap<Integer, List<Integer>> graph,
                                           boolean[] visited,
                                           int[] parent) {
        visited[v] = true;
        for (Integer u : graph.get(v)) {
            if (!visited[u]) {
                parent[u] = v;
                if (isCycleExistDFS(u, graph, visited, parent)) {
                    return true;
                }
            } else if (u != parent[v]) {
                return true;
            }
        }
        return false;
    }
}
