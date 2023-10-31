package DSAKiller.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {

    }

    static int[] topoSort(ArrayList<ArrayList<Integer>> graph, int N) {
        int[] order = new int[N];
        Arrays.fill(order, -1);
        int[] inDegrees = new int[N];
        for (ArrayList<Integer> list : graph) {
            for (Integer v : list) {
                inDegrees[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        int indexer = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order[indexer++] = v;
            for (int u : graph.get(v)) {
                inDegrees[u]--;
                if (inDegrees[u] == 0) {
                    queue.add(u);
                }
            }
        }

        return order;
    }
}
