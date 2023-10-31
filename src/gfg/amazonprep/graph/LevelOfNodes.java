package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOfNodes {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        g.add(a);

        a = new ArrayList<>();
        a.add(0);
        a.add(3);
        a.add(4);
        a.add(5);
        g.add(a);

        a = new ArrayList<>();
        a.add(0);
        a.add(6);
        g.add(a);

        a = new ArrayList<>();
        a.add(1);
        g.add(a);
        a = new ArrayList<>();
        a.add(1);
        g.add(a);
        a = new ArrayList<>();
        a.add(1);
        g.add(a);

        a = new ArrayList<>();
        a.add(2);
        a.add(7);
        g.add(a);

        a = new ArrayList<>();
        a.add(6);
        g.add(a);

        System.out.println(levels(g, g.size(), 7));
    }

    static int levels(ArrayList<ArrayList<Integer>> g, int N, int X) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> temp = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int level = 1;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            System.out.print(v + " ");
            if (v == X) {
                return level;
            }
            for (Integer w : g.get(v)) {
                if (!visited[w]) {
                    visited[w] = true;
                    temp.add(w);
                }
            }
            if (queue.isEmpty()) {
                while (!temp.isEmpty()) {
                    queue.add(temp.poll());
                }
                level++;
                System.out.print("\n");
            }
        }
        return -1;
    }
}
