package practice;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TopologicalSort {
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

        TopologicalSort obj = new TopologicalSort();
        System.out.print("\n");
        Stack<Integer> linkedList = new Stack<>();
        boolean[] visited = new boolean[graph.length];

        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                obj.topologicalSort(v, graph, linkedList, visited);
            }
        }
        System.out.print(obj.getDirectionalPath(linkedList));
    }

    private static void displayGraph(LinkedList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            for (Edge edge : graph[i]) {
                System.out.print("(" + edge.src + "->" + edge.dest + ")[" + edge.wt + "], ");
            }
            System.out.print("\n");
        }
    }

    public static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int v1, int v2, int wt) {
            this.src = v1;
            this.dest = v2;
            this.wt = wt;
        }
    }

    public static class Node implements Comparable<Node> {
        int val;
        int wsf;
        ArrayList<Integer> psf;
        public Node(int val, int wsf, ArrayList<Integer> psf) {
            this.val = val;
            this.wsf = wsf;
            this.psf = psf;
        }

        @Override
        public int compareTo(@NotNull Node o) {
            return Integer.compare(this.wsf, o.wsf);
        }
    }

    public void topologicalSort(int src, LinkedList<Edge>[] graph,
                                Stack<Integer> linkedList, boolean[] visited) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            if(!visited[e.dest]) {
                topologicalSort(e.dest, graph, linkedList, visited);
            }
        }
        linkedList.push(src);
    }

    private String getDirectionalPath(List<Integer> psf) {
        StringBuilder str = new StringBuilder("");
        for (Integer i : psf) {
            str.append(i).append("->");
        }
        return str.toString();
    }
}