package practice;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PrimsAlgo {
    public static void main(String[] args) {
        int n = 5;
        LinkedList<Edge>[] graph = new LinkedList[n];
        for (int i = 0; i < 5; i++) {
            graph[i] = new LinkedList<>();
        }
        graph[0].add(new Edge(0, 1, 2));
        graph[1].add(new Edge(1, 0, 2));

        graph[1].add(new Edge(1, 2, 4));
        graph[2].add(new Edge(2, 1, 4));

        graph[0].add(new Edge(0, 2, 3));
        graph[2].add(new Edge(2, 0, 3));

        graph[2].add(new Edge(2, 3, 5));
        graph[3].add(new Edge(3, 2, 5));

        graph[3].add(new Edge(3, 4, 6));
        graph[4].add(new Edge(4, 3, 6));

        graph[2].add(new Edge(2, 4, 4));
        graph[4].add(new Edge(4, 2, 4));

        displayGraph(graph);

        PrimsAlgo obj = new PrimsAlgo();
        System.out.print("\n");
        for (Integer i : obj.mst(graph)) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }

    private static void displayGraph(LinkedList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.v1 + "," + edge.v2 + ")[" + edge.wt + "], ");
            }
            System.out.print("\n");
        }
    }

    public static class Edge {
        int v1;
        int v2;
        int wt;

        public Edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    public static class Node implements Comparable<Node> {
        int val;
        int wt;
        public Node(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return Integer.compare(this.wt, o.wt);
        }
    }

    public List<Integer> mst(LinkedList<Edge>[] graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        pq.offer(new Node(0, 0));
        while (pq.size() > 0) {
            Node cur = pq.poll();
            if (visited[cur.val]) continue;
            visited[cur.val] = true;
            result.add(cur.val);
            System.out.println("(v: " + cur.val + "),(wt: " + cur.wt + ")");
            for (Edge e : graph[cur.val]) {
                if (!visited[e.v2]) {
                    pq.offer(new Node(e.v2, e.wt));
                }
            }
        }
        return result;
    }
}
