package gfg.amazonprep.graph;

import java.util.*;

public class TopologicalSort {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(2));
        list.add(new ArrayList<>());
        for (int i : topoSort(list, 3)) {
            System.out.print(i + " ");
        }
    }

    static int[] topoSort(ArrayList<List<Integer>> adj, int N) {
        int[] result = new int[N];
        int order = 0;
        int[] inDegrees = new int[N];
        for (int index = 0; index < inDegrees.length; index++) {
            result[index] = -1;
        }
        for (List<Integer> list : adj) {
            for (int v : list) {
                inDegrees[v] = inDegrees[v] + 1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int index = 0; index < inDegrees.length; index++) {
            if (inDegrees[index] == 0) {
                queue.add(index);
            }
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (result[v] == -1) {
                result[order++] = v;
            }
            for (Integer u : adj.get(v)) {
                inDegrees[u] = inDegrees[u] - 1;
                if (inDegrees[u] == 0) {
                    queue.add(u);
                }
            }
        }
        return result;
    }

}
