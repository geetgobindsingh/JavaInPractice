package ds.graph;

import java.util.ArrayList;

public class DijkstrasAlgo {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        w.add(0);
        w.add(1);
        w.add(43);
        g.add(w);
        w = new ArrayList<>();
        w.add(1);
        w.add(0);
        w.add(6);
        g.add(w);
        w = new ArrayList<>();
        w.add(43);
        w.add(6);
        w.add(0);
        g.add(w);

        for (int i : dijkstra(g, 2, 3)) {
            System.out.print(i + " ");
        }
    }

    static int getMinIndex(int dist[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!mstSet[i] && dist[i] < min) {
                min = dist[i];
                result = i;
            }
        }
        return result;
    }

    static int[] dijkstra(ArrayList<ArrayList<Integer>> g, int src, int V) {
        int dist[] = new int[V];
        boolean mstSet[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        dist[src] = 0;
        for (int v = 0; v < V - 1; v++) {
            int minIndex = getMinIndex(dist, mstSet);
            mstSet[minIndex] = true;
            for (int i = 0; i < V; i++) {
                int w = g.get(minIndex).get(i);
                if (w != 0 && !mstSet[i] && (dist[minIndex] + w) < dist[i]) {
                    dist[i] = dist[minIndex] + w;
                }
            }
        }
        return dist;
    }
}
