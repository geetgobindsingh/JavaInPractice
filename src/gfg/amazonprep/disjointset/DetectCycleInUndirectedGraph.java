package gfg.amazonprep.disjointset;

public class DetectCycleInUndirectedGraph {
    public DetectCycleInUndirectedGraph() {
        int n = 5; // number of nodes
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
            rank[i] = 1;
        }
    }

    public static int findSet(int i, int parent[]) {
        if (parent[i] == -1) {
            return i;
        }
        return findSet(parent[i], parent);
    }

    public static void unionSet(int x, int y, int parent[]) {
        int s1 = findSet(x, parent);
        int s2 = findSet(y, parent);
        if (s1 != s2) {
            parent[s2] = s1;
        }
    }

    // path compression
    public static int findSet2(int i, int parent[]) {
        if (parent[i] == -1) {
            return i;
        }
        parent[i] = findSet2(parent[i], parent);
        return parent[i];
    }

    //union by rank
    public static void unionSet2(int x, int y, int parent[], int rank[]) {
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
