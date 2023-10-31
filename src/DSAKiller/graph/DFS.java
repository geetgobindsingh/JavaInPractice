package DSAKiller.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DFS {
    public static void main(String[] args) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> adjList = new ArrayList<>();
        adjList.add(1);
        adjList.add(2);
        graph.put(0, adjList);
        adjList = new ArrayList<>();
        adjList.add(3);
        adjList.add(4);
        graph.put(1, adjList);
        adjList = new ArrayList<>();
        graph.put(2, adjList);
        adjList = new ArrayList<>();
        graph.put(3, adjList);
        adjList = new ArrayList<>();
        adjList.add(2); // back edge
        graph.put(4, adjList);
        dfs(graph);
    }

    public static void dfs(HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        dfsUtil(0, graph, visited);
    }

    public static void dfsUtil(Integer vertex, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (Integer u : graph.get(vertex)) {
            if (!visited[u]) {
                dfsUtil(u, graph, visited);
            }
        }
    }
}
