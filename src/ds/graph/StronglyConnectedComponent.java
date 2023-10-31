package ds.graph;

import java.util.ArrayList;
import java.util.Stack;

public class StronglyConnectedComponent {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(1);
        g.add(a);
        a = new ArrayList<>();
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        g.add(a);

        a = new ArrayList<>();
        g.add(a);
        // Kosaraju’s algorithm
        printStronglyConnectedComponent(g, g.size());
    }

    public static void DFSUtil(int v, ArrayList<ArrayList<Integer>> g, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int w : g.get(v)) {
            if (!visited[w]) {
                DFSUtil(w, g, visited);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> g) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < g.size(); i++) {
            graph.add(new ArrayList<>());
        }
        int v = 0;
        for (; v < g.size(); v++) {
            ArrayList<Integer> list = g.get(v);
            for (Integer i : list) {
                graph.get(i).add(v);
            }
        }
        return graph;
    }

    public static void fillOrder(int v, ArrayList<ArrayList<Integer>> g,
                                 Stack<Integer> stack, boolean[] visited) {
        visited[v] = true;
        for (int w : g.get(v)) {
            if (!visited[w]) {
                fillOrder(w, g, stack, visited);
            }
        }
        stack.add(v);
    }

    public static void printStronglyConnectedComponent(ArrayList<ArrayList<Integer>> g, int V) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        // get Stack after dfs traversal
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                fillOrder(i, g, stack, visited);
            }
        }

        // get transpose of graph
        g = transpose(g);

        // reset visited flags
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }
        // print SCC using stack and DFSUtil
        while (!stack.isEmpty()) {
            int i = stack.pop();
            if (!visited[i]) {
                DFSUtil(i, g, visited);
                System.out.print("\n");
            }
        }
    }
}
