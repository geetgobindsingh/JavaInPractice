package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DetectCycleInAnUndirectedGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = 46;
            int edg = 45;

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());
            //0 44 1 23 1 35 1 37 1 38 2 20 2 35 3 13 4 44 5 21 5 36 6 41 7 8 8 18 9 17 9 41 9 45 10 13 10 21 10 33 10 34 10 39 10 42 11 17 12 24 13 44 14 19 15 25 16 34 18 24 19 25 21 24 21 26 22 37 23 28 25 31 25 35 25 40 25 41 25 44 27 43 27 44 29 40 30 34 32 33
            for (int i = 1; i <= edg; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            if (new DetectCycleInAnUndirectedGraph().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }

    public static void main2(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        g.add(a);

        a = new ArrayList<>();
        a.add(0);
        a.add(2);
        g.add(a);

        a = new ArrayList<>();
        a.add(1);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        a.add(2);
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        a.add(3);
        g.add(a);
        System.out.print(isCyclic(g, g.size()));
    }


    static boolean isCyclic(ArrayList<ArrayList<Integer>> g, int V) {
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
        for (int index = 0; index < V; index++) {
            visited[index] = false;
            parent[index] = -1;
        }
        for (int index = 0; index < V; index++) {
            if (!visited[index] && isCyclicUtil(index, g, visited, -1)) {
//            if (!visited[index] && ha1sCycle(index, g, visited, parent)) {
                return true;
            }
        }
        return false;
    }

//    static boolean hasCycle(int v, ArrayList<ArrayList<Integer>> g, boolean[] visited, int[] parent) {
//        visited[v] = true;
//        for (Integer w : g.get(v)) { // This is not working for a particular case, need to find out why
//            if (!visited[w]) {
//                parent[w] = v;
//                return hasCycle(w, g, visited, parent);
//            } else if (w != parent[v]) {
//                return true;
//            }
//        }
//        return false;
//    }

    static Boolean isCyclicUtil(int v, ArrayList<ArrayList<Integer>> g, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = g.get(v).iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, g, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

}
