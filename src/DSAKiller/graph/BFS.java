package DSAKiller.graph;

import java.util.*;

public class BFS {
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
        bfs(graph);
    }

    public static void bfs(HashMap<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.size()];
        queue.offer(0);
        Integer current;
        while (!queue.isEmpty()) {
            current = queue.poll();
            visited[current] = true;
            System.out.print(current + " ");
            for (Integer adjNode : graph.get(current)) {
                if (!visited[adjNode]) {
                    queue.add(adjNode);
                }
            }
        }
    }
}
