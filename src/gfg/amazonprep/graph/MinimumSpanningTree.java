package gfg.amazonprep.graph;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<Integer> w = new ArrayList<>();
        w.add(Integer.MAX_VALUE); //1
        w.add(7);//2
        w.add(1);//3
        w.add(5);//4
        graph.add(w);
        w = new ArrayList<>();
        w.add(7);//1
        w.add(Integer.MAX_VALUE);//2
        w.add(Integer.MAX_VALUE);//3
        w.add(Integer.MAX_VALUE);//4
        graph.add(w);
        w = new ArrayList<>();
        w.add(1);//1
        w.add(Integer.MAX_VALUE);//2
        w.add(Integer.MAX_VALUE);//3
        w.add(11);//4
        graph.add(w);
        w = new ArrayList<>();
        w.add(5);//1
        w.add(Integer.MAX_VALUE);//2
        w.add(11);//3
        w.add(Integer.MAX_VALUE);//4
        graph.add(w);
        System.out.print(spanningTree(4, 4, graph));
    }

    // PRIMS Algorithm
    static int spanningTree1(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        int dis[] = new int[V];
        int parent[] = new int[V];
        for (int i = 0; i < V; i++) {
            dis[i] = -1;
            parent[i] = -1;
        }
        minHeap.add(new AbstractMap.SimpleEntry<>(0, 0));
        dis[0] = 0;
        while (!minHeap.isEmpty()) {
            int v = minHeap.poll().getValue();
            if (graph.get(v) != null) {
                ArrayList<Integer> weighList = graph.get(v);
                for (int index = 0; index < V; index++) {
                    int newWeight = dis[v] + weighList.get(index);
                    if (dis[index] == -1) {
                        dis[index] = weighList.get(index);
                        minHeap.add(new AbstractMap.SimpleEntry<>(newWeight, index));
                    } else if (newWeight < dis[index]) {
                        dis[index] = weighList.get(index);
                        minHeap.add(new AbstractMap.SimpleEntry<>(newWeight, index));
                    }
                    parent[index] = v;
                }
            }
        }
        return 0;
    }

    static int getMinIndex(int dist[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE;
        int result = -1;
        for (int i = 0; i < dist.length; i++) {
            if (!mstSet[i] && dist[i] <= min) {
                min = dist[i];
                result = i;
            }
        }
        return result;
    }

    static int spanningTree(int V, int E, ArrayList<ArrayList<Integer>> graph) {
        int dist[] = new int[V];
        boolean mstSet[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        dist[0] = 0;
        int sum = 0;
        for (int v = 0; v < V - 1; v++) {
            int minIndex = getMinIndex(dist, mstSet);
            mstSet[minIndex] = true;
            for (int i = 0; i < V; i++) {
                int w = graph.get(minIndex).get(i);
                if (w != 0
                        && !mstSet[i]
                        && (w) < dist[i]) {
                    dist[i] = w;
                }
            }
        }
        for (int i : dist) {
            sum = sum + i;
        }
        return sum;
    }
}
