package gfg.amazonprep.graph;

import java.util.ArrayList;

public class MotherVertex {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(1);
        g.add(a);
        a = new ArrayList<>();
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        g.add(a);

        System.out.print(findMother(g, g.size()));
    }

    private static void DFSUtil(int v, ArrayList<ArrayList<Integer>> g, boolean[] visited) {
        visited[v] = true;
        for (int w : g.get(v)) {
            if (!visited[w]) {
                DFSUtil(w, g, visited);
            }
        }
    }

    // Idea behind is thr last vertex visited by DFS is one of the mother vertex
    private static int findMother(ArrayList<ArrayList<Integer>> g, int n) {
        boolean[] visited = new boolean[n];
        int motherVertex = -1;
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                DFSUtil(v, g, visited);
                motherVertex = v;
            }
        }
        for (int v = 0; v < n; v++) {
            visited[v] = false;
        }
        DFSUtil(motherVertex, g, visited);
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                return -1;
            }
        }
        return motherVertex;
    }

}
