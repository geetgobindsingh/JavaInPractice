package DSAKiller.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstrasAlgo {
    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph, 0);
    }
    /*
    1  function Dijkstra(Graph, source):
    2
    3      create vertex set Q
    4
    5      for each vertex v in Graph:
    6          dist[v] ← INFINITY
    7          prev[v] ← UNDEFINED
    8          add v to Q
    9      dist[source] ← 0
    10
    11      while Q is not empty:
    12          u ← vertex in Q with min dist[u]
    13
    14          remove u from Q
    15
    16          for each neighbor v of u:           // only v that are still in Q
    17              alt ← dist[u] + length(u, v)
    18              if alt < dist[v]:
    19                  dist[v] ← alt
    20                  prev[v] ← u
    21
    22      return dist[], prev[]
     */

    static class Pair {
        int vertex;
        int distance;

        public Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static void dijkstra(int graph[][], int src) {
        boolean[] visited = new boolean[graph.length];
        int[] dist = new int[graph.length];
        int[] prev = new int[graph.length];
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);

        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.distance, o2.distance);
            }
        });
        Pair current = new Pair(0, 0);
        queue.add(current);
        dist[current.vertex] = 0;

        while (!queue.isEmpty()) {
            current = queue.poll();
            visited[current.vertex] = true;
            for (int u = 0; u < graph.length; u++) {
                if (graph[current.vertex][u] != 0) {
                    int distance = dist[current.vertex] + graph[current.vertex][u];
                    if (distance < dist[u] && !visited[u]) {
                        dist[u] = distance;
                        prev[u] = current.vertex;
                        queue.add(new Pair(u, distance));
                    }
                }
            }
        }

        for (int i = 0; i < graph.length; i++) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < graph.length; i++) {
            System.out.print(prev[i] + " ");
        }
    }
}
