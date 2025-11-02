package leetcode.medium;

import java.util.*;

public class RestoreTheArrayFromAdjacentPairs {
    public static void main(String[] args) {
        RestoreTheArrayFromAdjacentPairs obj = new RestoreTheArrayFromAdjacentPairs();
        for (int i : obj.restoreArray(new int[][]{
                {2, 1}, {3, 4}, {3, 2}
        })) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
        }
    }

    public int[] restoreArray(int[][] adjacentPairs) {
        Set<Integer> set = new LinkedHashSet<>();
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        for (int[] i : adjacentPairs) {
            set.add(i[0]);
            set.add(i[1]);
            g.putIfAbsent(i[0], new ArrayList<>());
            g.putIfAbsent(i[1], new ArrayList<>());
            g.get(i[0]).add(i[1]);
            g.get(i[1]).add(i[0]);
        }

        boolean[] visited = new boolean[set.size()];
        int[] ar = new int[set.size()];
        dfs(0, g, ar, new ArrayList<>(set), visited);
        return ar;
    }

    private void dfs(int i, HashMap<Integer, List<Integer>> g,
                     int[] ar, ArrayList<Integer> list, boolean[] visited) {
        if (i >= ar.length) return;
        if (visited[i]) return;
        visited[i] = true;
        ar[i] = list.get(i);
        for (Integer u : g.get(list.get(i))) {
            dfs(i + 1, g, ar, list, visited);
        }
    }

}
