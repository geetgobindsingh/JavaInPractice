package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(2);
        g.add(a);
        for (Integer i : bfs(g, g.size())) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            result.add(v);
            for (Integer w : g.get(v)) {
                if (!visited[w]) {
                    visited[v] = true;
                    queue.add(w);
                }
            }
        }
        return result;
    }
}
