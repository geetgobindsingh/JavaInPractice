package gfg.amazonprep.disjointset;

public class PairingProblem extends BaseGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.v = 5;
        graph.edgeList.add(new Pair<Integer, Integer>(0, 1));
        graph.edgeList.add(new Pair<Integer, Integer>(2, 3));
        graph.edgeList.add(new Pair<Integer, Integer>(0, 4));
        System.out.print(findNumberOfPair(graph));
    }

    public static int findNumberOfPair(Graph graph) {
        int[] parent = new int[graph.v];
        int[] rank = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }

        for (Pair<Integer, Integer> edge : graph.edgeList) {
            int x = edge.first;
            int y = edge.second;
            int s1 = findSet(x, parent);
            int s2 = findSet(y, parent);
            if (s1 != s2) {
                unionSet(s1, s2, parent, rank);
            } else {
                return 0;
            }
        }

        int ans = 0;
        for (int i = 0; i < graph.v; i++) {
            ans = ans + (graph.v - rank[findSet(i, parent)]);
        }
        return ans / 2;
    }

    public static int findSet(int i, int parent[]) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = findSet(parent[i], parent);
        return parent[i];
    }

    public static void unionSet(int x, int y, int parent[], int rank[]) {
        int s1 = findSet(x, parent);
        int s2 = findSet(y, parent);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
                rank[s2] += rank[s1];
            } else {
                parent[s2] = s1;
                rank[s1] += rank[s2];
            }
        }
    }
}
