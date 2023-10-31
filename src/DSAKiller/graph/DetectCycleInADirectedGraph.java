package DSAKiller.graph;

import java.util.*;

public class DetectCycleInADirectedGraph {
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

        System.out.println(cycleExistUsingBFS(graph));
        System.out.println(cycleExistUsingDFS(graph));
    }

    public static boolean cycleExistUsingBFS(HashMap<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(0);
        Integer v;
        while (!queue.isEmpty()) {
            v = queue.poll();
            visited[v] = true;
            for (Integer u : graph.get(v)) {
                if (!visited[u]) {
                    queue.offer(u);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleExistUsingDFS(HashMap<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        return isCycleExistDFS(0, graph, visited);
    }

    private static boolean isCycleExistDFS(int v,
                                           HashMap<Integer, List<Integer>> graph,
                                           boolean[] visited) {
        visited[v] = true;
        for (Integer u : graph.get(v)) {
            if (!visited[u]) {
                isCycleExistDFS(u, graph, visited);
            } else {
                return true;
            }
        }
        return false;
    }
}
