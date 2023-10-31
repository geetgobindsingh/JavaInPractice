package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TarjansAlgoStronglyConnectedComponent {

    public static int time = 0;

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
//        ArrayList<Integer> a = new ArrayList<>();
//        a.add(2);
//        a.add(3);
//        g.add(a);
//        a = new ArrayList<>();
//        a.add(0);
//        g.add(a);
//        a = new ArrayList<>();
//        a.add(1);
//        g.add(a);
//        a = new ArrayList<>();
//        a.add(4);
//        g.add(a);
//        a = new ArrayList<>();
//        g.add(a);
        ArrayList<Integer> a = new ArrayList<>();
        g.add(a);

        a = new ArrayList<>();
        a.add(2);
        g.add(a);

        a = new ArrayList<>();
        a.add(3);
        g.add(a);

        a = new ArrayList<>();
        a.add(1);
        g.add(a);
        // Tarjan’s algorithm
        find(g, g.size());
    }

    public static void find(ArrayList<ArrayList<Integer>> adj, int N) {
        // Write your code here
        boolean[] visited = new boolean[N];
        int[] disc = new int[N];
        int[] low = new int[N];
        boolean[] stackMember = new boolean[N];
        Stack<Integer> stack = new Stack<>();
        for (int v = 0; v < N; v++) {
            if (!visited[v]) {
                traverse(v, adj, disc, low, stack, stackMember, visited);
            }
        }
    }

    public static void traverse(int v, ArrayList<ArrayList<Integer>> adj, int[] disc,
                                int[] low, Stack<Integer> stack, boolean[] stackMember,
                                boolean[] visited) {
        time++;
        disc[v] = low[v] = time;
        stack.push(v);
        stackMember[v] = true;
        visited[v] = true;
        for (int u : adj.get(v)) {
            if (!visited[u]) {
                traverse(u, adj, disc, low, stack, stackMember, visited);
                low[v] = Math.min(low[v], low[u]);
            } else if (stackMember[u]) {
                low[v] = Math.min(low[v], disc[u]);
            }
        }
        if (low[v] == disc[v]) {
            while (v != stack.peek()) {
                int w = stack.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            stack.pop();
            stackMember[v] = false;
            System.out.print(v + " ");
            System.out.print("\n");
        }
    }
}
