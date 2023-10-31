package gfg.amazonprep.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> g = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        a.add(4);
        g.add(a);
        a = new ArrayList<>();
        a.add(0);
        g.add(a);
        a = new ArrayList<>();
        a.add(2);
        g.add(a);
        for (Integer i : dfs(g, g.size())) {
            System.out.print(i + " ");
        }
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        preOrder(g, N, 0, result, set);
        return result;
    }

    static void preOrder(ArrayList<ArrayList<Integer>> g, int N, int index,
                                       ArrayList<Integer> result, Set<Integer> set) {
        if (index >= N) {
            return;
        }
        if (!set.contains(index)) {
            result.add(index);
            set.add(index);
        }
        ArrayList<Integer> list = new ArrayList<>(g.get(index));
        for (Integer i : list) {
            if (!set.contains(i)) {
                preOrder(g, N, i, result, set);
            }
        }
    }

}
