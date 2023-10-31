package gfg.amazonprep.graph;

import java.util.ArrayList;

public class PossiblePathsBetweenTwoVertices {
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

        System.out.println(countPaths(g, g.size(), 7));
    }

    static int countPaths(ArrayList<ArrayList<Integer>> g, int s, int d) {
       return -1;
    }
}
