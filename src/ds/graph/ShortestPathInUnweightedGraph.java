package ds.graph;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    public static void main2(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        g.add(a);

        a = new ArrayList<>();
        a.add(0);
        g.add(a);

        a = new ArrayList<>();
        a.add(3);
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        a.add(2);
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        a.add(2);
        g.add(a);

        for (Integer w : bfsspanningTree(g, g.size())) {
            System.out.print(w + " ");
        }
        System.out.print("\n");
        for (Integer w : dfsspanningTree(g, g.size())) {
            System.out.print(w + " ");
        }
    }

    public static ArrayList<Integer> bfsspanningTree(ArrayList<ArrayList<Integer>> g, int V) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];
        for (int v = 0; v < g.size(); v++) {
            if (!visited[v]) {
                result.addAll(bfsUtil(v, g, V, visited));
            }
        }
        return result;
    }

    public static ArrayList<Integer> bfsUtil(int v, ArrayList<ArrayList<Integer>> g, int V, boolean visited[]) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        result.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int U = queue.poll();
            for (int w : g.get(U)) {
                if (!visited[w]) {
                    queue.add(w);
                    result.add(w);
                    visited[w] = true;
                }
            }
        }
        return result;
    }

    public static ArrayList<Integer> dfsspanningTree(ArrayList<ArrayList<Integer>> g, int V) {
        ArrayList<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[V];
        for (int v = 0; v < g.size(); v++) {
            if (!visited[v]) {
                dfsUtilUsingStack(v, g, V, visited, result);
//                dfsUtil(v, g, V, visited, result);
            }
        }
        return result;
    }


    public static void dfsUtil(int v, ArrayList<ArrayList<Integer>> g, int V,
                               boolean[] visited, ArrayList<Integer> result) {
        result.add(v);
        visited[v] = true;
        Iterator<Integer> iter = g.get(v).iterator();
        while (iter.hasNext()) {
            int U = iter.next();
            for (int w : g.get(U)) {
                if (!visited[w]) {
                    dfsUtil(w, g, V, visited, result);
                }
            }
        }
    }

    public static void dfsUtilUsingStack(int v, ArrayList<ArrayList<Integer>> g, int V,
                                         boolean[] visited, ArrayList<Integer> result) {
        Stack<Integer> stack = new Stack<>();
        stack.add(v);
        while (!stack.isEmpty()) {
            v = stack.pop();
            result.add(v);
            visited[v] = true;
            for (int w : g.get(v)) {
                if (!visited[w]) {
                    stack.push(w);
                }
            }
        }
    }


}
