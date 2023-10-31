package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycleInADirectedGraph {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        g.add(a);
        a = new ArrayList<>();
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        g.add(a);
        a = new ArrayList<>();
        g.add(a);
        System.out.print(isCyclic(g, g.size()));
    }

    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] inDegrees = new int[V];
        for (ArrayList<Integer> list : adj) {
            for (Integer v : list) {
                inDegrees[v] = inDegrees[v] + 1;
            }
        }
        int counter = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < V; index++) {
            if (inDegrees[index] == 0) {
                queue.add(index);
            }
        }
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            counter++;
            for (Integer w : adj.get(v)) {
                inDegrees[w] = inDegrees[w] - 1;
                if (inDegrees[w] == 0) {
                    queue.add(w);
                }
            }
        }
        if (counter == V) {
            return false;
        }
        return true;
    }

}
